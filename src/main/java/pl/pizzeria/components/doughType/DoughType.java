package pl.pizzeria.components.doughType;

import pl.pizzeria.components.menuPizza.MenuPizza;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dough_type")
public class DoughType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doughType")
    private Long id;

    @Column(name="dough_type")

    private String doughType;

    private double price;

    @OneToMany(mappedBy = "doughType")
    private List<MenuPizza> menuPizzaList = new ArrayList<>();

    public DoughType(){}

    public DoughType(String doughType, double price){
        this.doughType = doughType;
        this.price = price;
    }

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

    public List<MenuPizza> getMenuPizzaList() {
        return menuPizzaList;
    }

    public void setMenuPizzaList(List<MenuPizza> menuPizzaList) {
        this.menuPizzaList = menuPizzaList;
    }

    public void addMenuPizza(MenuPizza menuPizza){
        menuPizzaList.add(menuPizza);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoughType doughType1 = (DoughType) o;
        return Double.compare(doughType1.price, price) == 0 &&
                Objects.equals(id, doughType1.id) &&
                Objects.equals(doughType, doughType1.doughType) &&
                Objects.equals(menuPizzaList, doughType1.menuPizzaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doughType, price, menuPizzaList);
    }
}
