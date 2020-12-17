package pl.pizzeria.components.menuPizza.rest;

import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.toppings.rest.ToppingsMapper;

import java.util.stream.Collectors;

public class MenuPizzaPizzaMapper {

    public static MenuPizzaPizzaDto toDto (Pizza entity){
        MenuPizzaPizzaDto dto = new MenuPizzaPizzaDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setToppingsList(entity.getToppings()
                .stream()
                .map(ToppingsMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
