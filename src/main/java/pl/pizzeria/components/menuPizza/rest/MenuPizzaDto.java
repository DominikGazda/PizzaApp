package pl.pizzeria.components.menuPizza.rest;

public class MenuPizzaDto {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String pizzaName;
    private String pizzaSize;
    private String doughType;

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
