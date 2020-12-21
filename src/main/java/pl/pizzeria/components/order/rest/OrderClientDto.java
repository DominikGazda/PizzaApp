package pl.pizzeria.components.order.rest;

import pl.pizzeria.components.client.rest.ClientDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderClientDto {

    private Long orderId;
    private Long clientId;
    @NotEmpty(message = "{pl.pizzeria.components.order.rest.OrderDto.clientName.NotEmpty}")
    private String clientName;
    @NotEmpty(message = "{pl.pizzeria.components.order.rest.OrderDto.clientSurname.NotEmpty}")
    private String clientSurname;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}