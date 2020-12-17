package pl.pizzeria.components.client.rest;

import pl.pizzeria.components.order.OrderStatus;

public class ClientOrderDto {
    private Long orderId;
    private Integer deskNumber;
    private Long waiterId;
    private OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(Integer deskNumber) {
        this.deskNumber = deskNumber;
    }

    public Long getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }
}
