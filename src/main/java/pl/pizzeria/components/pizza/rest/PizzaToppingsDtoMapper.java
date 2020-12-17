package pl.pizzeria.components.pizza.rest;

import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.toppings.Toppings;

import java.util.stream.Collectors;

public class PizzaToppingsDtoMapper {

    public static PizzaToppingsDto toDto(Pizza pizza){
        PizzaToppingsDto dto = new PizzaToppingsDto();
        dto.setPizzaId(pizza.getId());
        dto.setToppings(pizza.getToppings()
                .stream()
                .map(Toppings::getName)
                .map(String::toString)
                .collect(Collectors.toList()));
        return dto ;
    }
}
