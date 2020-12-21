package pl.pizzeria.components.pizza.rest;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class PizzaDto {

    private Long id;
    @NotEmpty(message = "{pl.pizzeria.components.pizza.rest.PizzaDto.name.NotEmpty}")
    private String name;
    private String imageUrl;
    private List<String> toppingsList;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getToppingsList() {
        return toppingsList;
    }

    public void setToppingsList(List<String> toppingsList) {
        this.toppingsList = toppingsList;
    }
}
