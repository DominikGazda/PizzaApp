package pl.pizzeria.components.pizza;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.toppings.Toppings;

import javax.persistence.*;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
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

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", toppingsList=" + toppingsList +
                '}';
    }
}
