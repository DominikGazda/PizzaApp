package pl.pizzeria.components.order.rest;

public class OrderWaiterDto {

    private Long orderId;
    private Long waiterId;
    private String waiterName;
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
