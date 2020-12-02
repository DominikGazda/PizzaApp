package pl.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
}
