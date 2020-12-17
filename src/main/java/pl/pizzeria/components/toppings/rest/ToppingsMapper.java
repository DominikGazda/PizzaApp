package pl.pizzeria.components.toppings.rest;

import pl.pizzeria.components.toppings.Toppings;
import pl.pizzeria.components.toppings.rest.ToppingsDto;

public class ToppingsMapper {

    public static ToppingsDto toDto(Toppings entity){
        ToppingsDto dto = new ToppingsDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public static Toppings toEntity(ToppingsDto dto){
        Toppings toppings = new Toppings();
        toppings.setId(dto.getId());
        toppings.setName(dto.getName());
        toppings.setPrice(dto.getPrice());
        return toppings;
    }
}
