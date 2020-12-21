package pl.pizzeria.components.client;

import pl.pizzeria.components.order.Order;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    @NotEmpty
    @Column(name="name")
    private String clientName;

    @NotEmpty
    @Column(name = "surname")
    private String clientSurname;

    @OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
    private List <Order> orders = new ArrayList<>();

    public Client(){}

    public Client(String name, String surname){
        this.clientName = clientName;
        this.clientSurname = clientSurname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        order.setClient(this);
        orders.add(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(clientName, client.clientName) &&
                Objects.equals(clientSurname, client.clientSurname) &&
                Objects.equals(orders, client.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName, clientSurname, orders);
    }
}
