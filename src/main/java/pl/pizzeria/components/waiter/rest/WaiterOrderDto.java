package pl.pizzeria.components.waiter.rest;

import pl.pizzeria.components.pizza.rest.PizzaDto;

import java.sql.Date;

public class WaiterOrderDto {

    private String clientName;
    private String clientSurname;
    private WaiterPizzaDto pizza;
    private String pizzaSize;
    private String doughType;
    private int deskNumber;
    private Date dateTime;
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

    public WaiterPizzaDto getPizza() {
        return pizza;
    }

    public void setPizza(WaiterPizzaDto pizza) {
        this.pizza = pizza;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(int deskNumber) {
        this.deskNumber = deskNumber;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getDoughType() {
        return doughType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }
}
