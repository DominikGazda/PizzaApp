package pl.pizzeria.components.order.rest;

import org.springframework.stereotype.Service;
import pl.pizzeria.components.client.Client;
import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.menuPizza.rest.MenuPizzaMapper;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.order.OrderStatus;
import pl.pizzeria.components.waiter.Waiter;
import pl.pizzeria.components.waiter.WaiterRepository;
import pl.pizzeria.components.waiter.exceptions.WaiterNotFoundException;

import javax.persistence.EntityManager;
import java.util.Optional;


@Service
public class OrderMapper {

    private WaiterRepository waiterRepository;
    private MenuPizzaMapper menuPizzaMapper;
    private EntityManager entityManager;

    public OrderMapper(WaiterRepository waiterRepository, MenuPizzaMapper menuPizzaMapper,
                       EntityManager entityManager){
        this.waiterRepository = waiterRepository;
        this.menuPizzaMapper = menuPizzaMapper;
        this.entityManager = entityManager;
    }

    public OrderDto toDto (Order entity){
        OrderDto dto = new OrderDto();
        dto.setOrderId(entity.getId());
        dto.setClientId(entity.getClient().getId());
        dto.setClientName(entity.getClient().getClientName());
        dto.setClientSurname(entity.getClient().getClientSurname());
        dto.setWaiterId(entity.getWaiter().getId());
        dto.setWaiterName(entity.getWaiter().getName());
        dto.setWaiterSurname(entity.getWaiter().getSurname());
        dto.setDeskNumber(entity.getTableNumber());
        dto.setDateTime(entity.getDate());
        dto.setPizzaList(menuPizzaMapper.toDto(entity.getMenuPizza()));
        return dto;
    }

    public Order toEntity (OrderDto dto){
        Order order = new Order();
        Optional<Waiter> optionalWaiter = waiterRepository.findById(dto.getWaiterId());

        Waiter waiter = optionalWaiter.orElseThrow(WaiterNotFoundException::new);

        Client client = new Client();
        client.setId(dto.getClientId());
        client.setClientName(dto.getClientName());
        client.setClientSurname(dto.getClientSurname());

        MenuPizza menuPizza = menuPizzaMapper.toEntity(dto.getPizzaList());

        order.setId(dto.getOrderId());
        order.setTableNumber(dto.getDeskNumber());
        order.setStatus(OrderStatus.NEW);
        order.setDate(dto.getDateTime());
        order.setWaiter(waiter);
        order.setClient(client);
        order.setMenuPizza(menuPizza);
        return order;
    }

}
