package pl.pizzeria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pizza")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany
    @JoinTable(name = "pizza_toppings",
    joinColumns = {@JoinColumn(name = "pizzaId" , referencedColumnName = "id_pizza")},
    inverseJoinColumns = {@JoinColumn(name = "topping_id", referencedColumnName = "id_topping")})
    private List <Toppings>toppingsList = new ArrayList<>();

    @OneToMany(mappedBy = "pizza")
    private List<MenuPizza>menuPizzaList = new ArrayList<>();

    public Pizza(){}

    public Pizza(String name){
        this.name = name;
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

    public List<MenuPizza> getMenuPizza() {
        return menuPizzaList;
    }

    public void setMenuPizza(List<MenuPizza> menuPizza) {
        this.menuPizzaList = menuPizza;
    }

    public void addMenuPizza(MenuPizza menuPizza){
        menuPizzaList.add(menuPizza);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Toppings> getToppings() {
        return toppingsList;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppingsList = toppings;
    }

    public List<MenuPizza> getMenuPizzaList() {
        return menuPizzaList;
    }

    public void setMenuPizzaList(List<MenuPizza> menuPizzaList) {
        this.menuPizzaList = menuPizzaList;
    }

}
