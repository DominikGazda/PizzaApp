package pl.pizzeria.components.toppings.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pizzeria.components.pizza.Pizza;
import pl.pizzeria.components.pizza.rest.PizzaMapper;
import pl.pizzeria.components.toppings.Toppings;

import java.util.stream.Collectors;

@Service
public class ToppingsPizzaMapper {

    private PizzaMapper pizzaMapper;

    @Autowired
    public ToppingsPizzaMapper(PizzaMapper pizzaMapper){
        this.pizzaMapper = pizzaMapper;
    }

    public ToppingsPizzaDto toDto(Toppings toppings){
        ToppingsPizzaDto toppingsPizzaDto = new ToppingsPizzaDto();
        toppingsPizzaDto.setToppingsId(toppings.getId());
        toppingsPizzaDto.setPizzaList(toppings.getPizza().stream()
                .map(pizzaMapper::toDto)
                .collect(Collectors.toList()));
        return toppingsPizzaDto;
    }
}
