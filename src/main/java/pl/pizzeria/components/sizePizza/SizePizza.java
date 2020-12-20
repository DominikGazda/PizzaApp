package pl.pizzeria.components.sizePizza;

import pl.pizzeria.components.menuPizza.MenuPizza;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizePizza sizePizza = (SizePizza) o;
        return Double.compare(sizePizza.toppingDoublePrice, toppingDoublePrice) == 0 &&
                Objects.equals(id, sizePizza.id) &&
                Objects.equals(size, sizePizza.size) &&
                Objects.equals(menuPizzaList, sizePizza.menuPizzaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, toppingDoublePrice, menuPizzaList);
    }
}
