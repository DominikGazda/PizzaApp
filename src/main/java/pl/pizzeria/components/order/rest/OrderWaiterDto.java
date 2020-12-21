package pl.pizzeria.components.order.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class OrderWaiterDto {

    private Long orderId;

    private Long waiterId;
    @NotEmpty(message = "{pl.pizzeria.components.order.rest.OrderDto.waiterName}")
    private String waiterName;
    @NotEmpty(message = "{pl.pizzeria.components.order.rest.OrderDto.waiterSurname}")
    private String waiterSurname;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
}
