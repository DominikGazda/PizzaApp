package pl.pizzeria.components.waiter;

import pl.pizzeria.components.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="waiters")
public class Waiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_waiter")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToMany(mappedBy = "waiter")
    private List<Order> orders = new ArrayList<>();

    public Waiter(){}

    public Waiter(String name, String surname){
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return Objects.equals(id, waiter.id) &&
                Objects.equals(name, waiter.name) &&
                Objects.equals(surname, waiter.surname) &&
                Objects.equals(orders, waiter.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, orders);
    }
}
