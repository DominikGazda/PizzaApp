package pl.pizzeria.components.menuPizza.rest;

import javax.validation.constraints.NotEmpty;

public class MenuPizzaDto {

    private Long id;
    @NotEmpty(message = "{pl.pizzeria.components.menuPizza.rest.MenuPizzaDto.pizzaName.NotEmpty}")
    private String pizzaName;
    @NotEmpty(message = "{pl.pizzeria.components.menuPizza.rest.MenuPizzaDto.pizzaSize.NotEmpty}")
    private String pizzaSize;
    @NotEmpty(message = "{pl.pizzeria.components.menuPizza.rest.MenuPizzaDto.doughType.NotEmpty}")
    private String doughType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getDoughType() {
        return doughType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }


}
