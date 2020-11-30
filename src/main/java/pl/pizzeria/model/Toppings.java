package pl.pizzeria.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="toppings")
public class Toppings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_topping")
    private Long id;

    @Column(name = "topping_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @ManyToMany(mappedBy = "toppingsList", cascade = CascadeType.PERSIST)
    private List<Pizza> pizza = new ArrayList<>();

    public Toppings(){}

    public Toppings(String name, double price){
        this.name = name;
        this.price = price;
    }

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

    public List<Pizza> getPizza() {
        return pizza;
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizza = pizza;
    }

}
