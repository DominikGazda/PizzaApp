package pl.pizzeria.components.client.rest;

import pl.pizzeria.components.order.Order;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class ClientDto {

    private Long id;
    private String clientName;
    private String clientSurname;

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
}
