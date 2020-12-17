package pl.pizzeria.components.toppings.rest;

import pl.pizzeria.components.pizza.rest.PizzaDto;

import java.util.List;

public class ToppingsPizzaDto {

    private Long toppingsId;
    private List<PizzaDto> pizzaList;

    public Long getToppingsId() {
        return toppingsId;
    }

    public void setToppingsId(Long toppingsId) {
        this.toppingsId = toppingsId;
    }

    public List<PizzaDto> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<PizzaDto> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
