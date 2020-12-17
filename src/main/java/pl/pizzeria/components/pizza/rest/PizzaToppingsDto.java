package pl.pizzeria.components.pizza.rest;

import java.util.List;

public class PizzaToppingsDto {

    private Long pizzaId;
    private List<String> toppings;

    public Long getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
}
