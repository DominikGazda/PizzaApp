package pl.pizzeria.components.order.rest;

import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.waiter.Waiter;

public class OrderWaiterMapper {

    public static OrderWaiterDto toDto (Order order){
        OrderWaiterDto dto = new OrderWaiterDto();
        if(order.getWaiter().getId() != null)
            dto.setWaiterId(order.getWaiter().getId());
        dto.setWaiterName(order.getWaiter().getName());
        dto.setWaiterSurname(order.getWaiter().getSurname());
        dto.setOrderId(order.getId());
        return dto;
    }
}
