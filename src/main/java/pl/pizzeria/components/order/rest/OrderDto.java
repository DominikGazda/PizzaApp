package pl.pizzeria.components.order.rest;

import pl.pizzeria.components.menuPizza.MenuPizza;
import pl.pizzeria.components.menuPizza.rest.MenuPizzaDto;
import pl.pizzeria.components.pizza.rest.PizzaDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    private Long orderId;
    @NotNull(message = "{pl.pizzeria.components.order.rest.OrderDto.clientId.NotNull}")
    private Long clientId;
    @NotEmpty(message = "{pl.pizzeria.components.order.rest.OrderDto.clientName.NotEmpty}")
    private String clientName;
    @NotEmpty(message = "{pl.pizzeria.components.order.rest.OrderDto.clientSurname.NotEmpty}")
    private String clientSurname;
    @NotNull(message = "{pl.pizzeria.components.order.rest.OrderDto.pizzaList.NotNull}")
    private MenuPizzaDto pizzaList;
    @NotNull(message = "{pl.pizzeria.components.order.rest.OrderDto.waiterId.NotNull}")
    private Long waiterId;
    @NotEmpty(message = "{pl.pizzeria.components.order.rest.OrderDto.waiterName.NotEmpty}")
    private String waiterName;
    @NotEmpty(message = "{pl.pizzeria.components.order.rest.OrderDto.waiterSurname.NotEmpty}")
    private String waiterSurname;
    @Min(1)
    private int deskNumber;
    @NotNull(message = "{pl.pizzeria.components.order.rest.OrderDto.dateTime.NotNull}")
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
