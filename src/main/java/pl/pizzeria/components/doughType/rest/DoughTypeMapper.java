package pl.pizzeria.components.doughType.rest;


import pl.pizzeria.components.doughType.DoughType;

public class DoughTypeMapper {

    public static DoughTypeDto toDto (DoughType entity){
        DoughTypeDto dto = new DoughTypeDto();
        dto.setId(entity.getId());
        dto.setDoughType(entity.getDoughType());
        dto.setPrice(entity.getPrice());
        return dto;
    }
}
