package pl.pizzeria.components.doughType.rest;

public class DoughTypeDto {

    private Long id;
    private String doughType;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoughType() {
        return doughType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
