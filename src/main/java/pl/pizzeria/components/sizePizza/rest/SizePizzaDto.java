package pl.pizzeria.components.sizePizza.rest;

public class SizePizzaDto {

    private Long id;
    private String size;
    private double toppingDoublePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getToppingDoublePrice() {
        return toppingDoublePrice;
    }

    public void setToppingDoublePrice(double toppingDoublePrice) {
        this.toppingDoublePrice = toppingDoublePrice;
    }
}
