package pl.pizzeria.components.order;

import pl.pizzeria.components.client.Client;
import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.waiter.Waiter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    private int tableNumber;

    private Date date;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne(cascade =CascadeType.PERSIST)
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private Waiter waiter;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "menu_pizza_id")
    private MenuPizza menuPizza;

    public Order (){};

    public Order(int tableNumber, Date date){
        this.tableNumber = tableNumber;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public MenuPizza getMenuPizza() {
        return menuPizza;
    }

    public void setMenuPizza(MenuPizza menuPizza) {
        this.menuPizza = menuPizza;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return tableNumber == order.tableNumber &&
                Objects.equals(id, order.id) &&
                Objects.equals(date, order.date) &&
                status == order.status &&
                Objects.equals(client, order.client) &&
                Objects.equals(waiter, order.waiter) &&
                Objects.equals(menuPizza, order.menuPizza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tableNumber, date, status, client, waiter, menuPizza);
    }
}
