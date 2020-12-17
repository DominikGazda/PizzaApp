package pl.pizzeria.components.menuPizza.rest;

import org.springframework.stereotype.Service;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.order.OrderStatus;

@Service
public class MenuPizzaOrderMapper {

    public static MenuPizzaOrderDto toDto(Order order){
        MenuPizzaOrderDto dto = new MenuPizzaOrderDto();
        dto.setId(order.getId());
        dto.setTableNumber(order.getTableNumber());
        dto.setStatus(order.getStatus().name());
        dto.setWaiterId(order.getWaiter().getId());
        return dto;
    }
}
