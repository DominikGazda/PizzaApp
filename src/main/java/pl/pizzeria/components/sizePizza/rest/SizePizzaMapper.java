package pl.pizzeria.components.sizePizza.rest;

import pl.pizzeria.components.sizePizza.SizePizza;

public class SizePizzaMapper {

    public static SizePizzaDto toDto(SizePizza entity){
        SizePizzaDto dto = new SizePizzaDto();
        dto.setId(entity.getId());
        dto.setSize(entity.getSize());
        dto.setToppingDoublePrice(entity.getToppingDoublePrice());
        return dto;
    }
}
