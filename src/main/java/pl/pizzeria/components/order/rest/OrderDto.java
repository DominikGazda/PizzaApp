package pl.pizzeria.components.order.rest;

import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.menuPizza.rest.MenuPizzaDto;
import pl.pizzeria.components.pizza.rest.PizzaDto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    private Long orderId;
    private Long clientId;
    private String clientName;
    private String clientSurname;
    private MenuPizzaDto pizzaList;
    private Long waiterId;
    private String waiterName;
    private String waiterSurname;
    private int deskNumber;
    private Date dateTime;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public MenuPizzaDto getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(MenuPizzaDto pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Long getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getWaiterSurname() {
        return waiterSurname;
    }

    public void setWaiterSurname(String waiterSurname) {
        this.waiterSurname = waiterSurname;
    }

    public int getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(int deskNumber) {
        this.deskNumber = deskNumber;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
