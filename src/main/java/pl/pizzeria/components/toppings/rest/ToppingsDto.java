package pl.pizzeria.components.toppings.rest;

import pl.pizzeria.components.pizza.Pizza;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class ToppingsDto {

    private Long id;

    @NotEmpty(message = "{pl.pizzeria.components.toppings.rest.ToppingsDto.name.NotEmpty}")
    private String name;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
