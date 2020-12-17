package pl.pizzeria.components.order.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import pl.pizzeria.components.client.Client;
import pl.pizzeria.components.client.ClientRepository;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.order.OrderRepository;
import pl.pizzeria.components.order.exceptions.OrderNotFoundException;

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

    public List<OrderDto> findAllOrders(){
        return orderRepository.findAll()
                .stream()
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
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Object doesn't exists");
        foundOrder.setClient(null);
        clientRepository.delete(createClientEntity(dto));
        return dto;
    }

    private Client createClientEntity(OrderClientDto dto){
        Client client = new Client();
        client.setId(dto.getClientId());
        client.setClientName(dto.getClientName());
        client.setClientSurname(dto.getClientSurname());
        return client;
    }


}
