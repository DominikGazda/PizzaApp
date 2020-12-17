package pl.pizzeria.components.order.rest;

import pl.pizzeria.components.client.Client;
import pl.pizzeria.components.order.Order;

public class OrderClientMapper {

    public static OrderClientDto toDto(Order order){
        OrderClientDto dto = new OrderClientDto();
        dto.setOrderId(order.getId());
        dto.setClientId(order.getClient().getId());
        dto.setClientName(order.getClient().getClientName());
        dto.setClientSurname(order.getClient().getClientSurname());
        return dto;
    }

}
