package pl.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MenuPizza")
public class MenuPizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_pizza")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pizza_id")
    //@JsonBackReference
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "size_pizza_id")
    private SizePizza sizePizza;

    @ManyToOne
    @JoinColumn(name = "dough_type_id")
    private DoughType doughType;

    @OneToMany(mappedBy = "menuPizza")
    private List<Order> orders = new ArrayList<>();

    @Column(name="price")
    private double price;

    public MenuPizza(){}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public SizePizza getSizePizza() {
        return sizePizza;
    }

    public void setSizePizza(SizePizza sizePizza) {
        this.sizePizza = sizePizza;
    }

    public DoughType getDoughType() {
        return doughType;
    }

    public void setDoughType(DoughType doughType) {
        this.doughType = doughType;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public void addOrder(Order order){
        order.setMenuPizza(this);
        orders.add(order);
    }
}
