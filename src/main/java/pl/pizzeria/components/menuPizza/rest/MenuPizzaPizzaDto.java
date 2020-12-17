package pl.pizzeria.components.menuPizza.rest;

import pl.pizzeria.components.toppings.rest.ToppingsDto;

import java.util.List;

public class MenuPizzaPizzaDto {

    private Long id;
    private String name;
    private List<ToppingsDto> toppingsList;

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

    public List<ToppingsDto> getToppingsList() {
        return toppingsList;
    }

    public void setToppingsList(List<ToppingsDto> toppingsList) {
        this.toppingsList = toppingsList;
    }
}
