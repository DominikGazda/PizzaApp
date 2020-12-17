package pl.pizzeria.components.pizza.rest;

import org.springframework.stereotype.Service;
import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.pizza.exception.PizzaToppingNotFoundException;
import pl.pizzeria.components.toppings.Toppings;
import pl.pizzeria.components.toppings.ToppingsRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaMapper {

    private ToppingsRepository toppingsRepository;

    public PizzaMapper (ToppingsRepository toppingsRepository){
        this.toppingsRepository = toppingsRepository;
    }

    public PizzaDto toDto (Pizza entity){
        PizzaDto dto = new PizzaDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImageUrl(entity.getImageUrl());
        dto.setToppingsList(entity.getToppings()
                .stream()
                .map(Toppings::getName)
                .collect(Collectors.toList()));
        return dto;
    }

    public  Pizza toEntity(PizzaDto dto) {
        Pizza entity = new Pizza();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setImageUrl(dto.getImageUrl());

        for(String name:dto.getToppingsList()){
            Optional<Toppings> topping = toppingsRepository.findByName(name);
            Toppings toppings = topping.orElseThrow(PizzaToppingNotFoundException::new);
            entity.getToppings().add(toppings);
            }
        return entity;
    }
}
