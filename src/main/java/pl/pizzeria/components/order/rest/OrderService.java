package pl.pizzeria.components.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pl.pizzeria.components.client.Client;
import pl.pizzeria.components.client.ClientRepository;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.order.OrderRepository;
import pl.pizzeria.components.order.OrderStatus;
import pl.pizzeria.components.order.exceptions.OrderNotFoundException;
import pl.pizzeria.components.waiter.Waiter;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private EntityManager entityManager;
    private ClientRepository clientRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, EntityManager entityManager,
                        ClientRepository clientRepository){
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.entityManager = entityManager;
        this.clientRepository = clientRepository;
    }

    public List<OrderDto> findAllOrders(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Order> pageResult =  orderRepository.findAll(paging);
        return pageResult.get()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDto save(OrderDto dto){
        if(dto.getOrderId() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot add object with id");
       Order order = orderMapper.toEntity(dto);
       order.setMenuPizza(entityManager.merge(order.getMenuPizza()));
       order.setClient(entityManager.merge(order.getClient()));
       Order savedOrder = orderRepository.save(order);
       return orderMapper.toDto(savedOrder);
    }

    public OrderDto findOrderByID(Long id){
        return orderRepository.findById(id)
                .map(orderMapper::toDto)
                .orElseThrow(OrderNotFoundException::new);
    }

    @Transactional
    public OrderDto update(OrderDto orderDto){
        Order order = orderMapper.toEntity(orderDto);
        order.setMenuPizza(entityManager.merge(order.getMenuPizza()));
        order.setClient(entityManager.merge(order.getClient()));
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    public OrderDto delete(Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order orderToDelete = orderOptional.orElseThrow(OrderNotFoundException::new);
        orderRepository.delete(orderToDelete);
        return orderMapper.toDto(orderToDelete);
    }

    public OrderClientDto findClientInOrder(Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        Order order = orderOptional.orElseThrow(OrderNotFoundException::new);
        return OrderClientMapper.toDto(order);
    }

    public OrderClientDto saveClientInOrder(OrderClientDto dto){
        Optional<Order> optionalOrder = orderRepository.findById(dto.getOrderId());
        Order foundOrder = optionalOrder.orElseThrow(OrderNotFoundException::new);
        if(foundOrder.getClient() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Order has assigned client");
        Client client = createClientEntity(dto);
        foundOrder.setClient(client);
        orderRepository.save(foundOrder);
        return OrderClientMapper.toDto(foundOrder);
    }

    public OrderClientDto deleteClientInOrder(OrderClientDto dto){
        Optional<Order> optionalOrder = orderRepository.findById(dto.getOrderId());
        Order foundOrder = optionalOrder.orElseThrow(OrderNotFoundException::new);
        if(foundOrder.getClient() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Order doesn't have assigned client");
        foundOrder.setClient(null);
        clientRepository.delete(createClientEntity(dto));
        return dto;
    }

    public OrderWaiterDto findWaiterInOrder(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        Order foundOrder = optionalOrder.orElseThrow(OrderNotFoundException::new);
        if(foundOrder.getWaiter() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Order doesn't have assigned waiter");
        return OrderWaiterMapper.toDto(foundOrder);
    }

    public OrderWaiterDto saveWaiterInOrder(OrderWaiterDto dto){
        Optional<Order> optionalOrder = orderRepository.findById(dto.getOrderId());
        Order foundOrder = optionalOrder.orElseThrow(OrderNotFoundException::new);
        if(foundOrder.getWaiter() != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Order already has assigned waiter");
        Waiter waiterToSave = createWaiterEntity(dto);
        foundOrder.setWaiter(waiterToSave);
        Order savedOrder = orderRepository.save(foundOrder);
        return OrderWaiterMapper.toDto(savedOrder);
    }

    public OrderWaiterDto deleteWaiterInOrder(OrderWaiterDto dto){
        Optional<Order> optionalOrder = orderRepository.findById(dto.getOrderId());
        Order foundOrder = optionalOrder.orElseThrow(OrderNotFoundException::new);
        if(foundOrder.getWaiter() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Order doesn't have assigned waiter");
        foundOrder.setWaiter(null);
        orderRepository.save(foundOrder);
        return dto;
    }

    public List<OrderDto>findOrdersBYStatus(OrderStatus status){
        if(status == null)
            return findAllOrders(0,10,"id");
        return orderRepository.findAllByStatus(status).stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    private Client createClientEntity(OrderClientDto dto){
        Client client = new Client();
        client.setId(dto.getClientId());
        client.setClientName(dto.getClientName());
        client.setClientSurname(dto.getClientSurname());
        return client;
    }

    private Waiter createWaiterEntity(OrderWaiterDto dto){
        Waiter waiter = new Waiter();
        waiter.setId(dto.getWaiterId());
        waiter.setName(dto.getWaiterName());
        waiter.setSurname(dto.getWaiterSurname());
        return waiter;
    }

}
