package pl.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pizza_size")
public class SizePizza {

    @Id
    @GeneratedValue
    @Column(name="id_pizza_size")
    private Long id;

    @Column(name = "size_name", nullable = false)
    private String size;

    @Column(name = "topping_double_price")
    private double toppingDoublePrice;   //if double_toppings is true

    @OneToMany(mappedBy = "sizePizza")
    private List<MenuPizza> menuPizzaList = new ArrayList<>();

    public SizePizza(){}

    public SizePizza(String size, double toppingDoublePrice){
        this.size = size;
        this.toppingDoublePrice = toppingDoublePrice;
    }

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

    public List<MenuPizza> getMenuPizzaList() {
        return menuPizzaList;
    }

    public void setMenuPizzaList(List<MenuPizza> menuPizzaList) {
        this.menuPizzaList = menuPizzaList;
    }

    public void addMenuPizzaList(MenuPizza menuPizza){
        menuPizzaList.add(menuPizza);
    }
}
