package pl.pizzeria.components.waiter.rest;

import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.toppings.rest.ToppingsMapper;

public class WaiterPizzaMapper {

    public static WaiterPizzaDto toDto(Pizza pizza){
        WaiterPizzaDto waiterPizzaDto = new WaiterPizzaDto();
        waiterPizzaDto.setId(pizza.getId());
        waiterPizzaDto.setName(pizza.getName());
        return waiterPizzaDto;
    }
}
