package pl.pizzeria.components.waiter.rest;

import org.springframework.stereotype.Service;
import pl.pizzeria.components.order.Order;
import pl.pizzeria.components.pizza.rest.PizzaMapper;

@Service
public class WaiterOrderMapper {

    private PizzaMapper pizzaMapper;

    public WaiterOrderMapper(PizzaMapper pizzaMapper){
        this.pizzaMapper = pizzaMapper;
    }

    public WaiterOrderDto toDto (Order order){
        WaiterOrderDto waiterOrderDto = new WaiterOrderDto();
        waiterOrderDto.setClientName(order.getClient().getClientName());
        waiterOrderDto.setClientSurname(order.getClient().getClientSurname());
        waiterOrderDto.setDeskNumber(order.getTableNumber());
        waiterOrderDto.setDateTime(order.getDate());
        waiterOrderDto.setPizza(WaiterPizzaMapper.toDto(order.getMenuPizza().getPizza()));
        waiterOrderDto.setDoughType(order.getMenuPizza().getDoughType().getDoughType());
        waiterOrderDto.setPizzaSize(order.getMenuPizza().getSizePizza().getSize());
        
        return waiterOrderDto;
    }
}
