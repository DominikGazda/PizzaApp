package pl.pizzeria.components.waiter.rest;

import pl.pizzeria.components.waiter.Waiter;

public class WaiterMapper {

    public static WaiterDto toDto(Waiter entity){
        WaiterDto dto = new WaiterDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        return dto;
    }

    public static Waiter toEntity(WaiterDto dto){
        Waiter waiter = new Waiter();
        waiter.setId(dto.getId());
        waiter.setName(dto.getName());
        waiter.setSurname(dto.getSurname());
        return waiter;
    }
}
