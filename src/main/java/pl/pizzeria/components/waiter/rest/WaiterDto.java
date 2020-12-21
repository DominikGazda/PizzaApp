package pl.pizzeria.components.waiter.rest;

import javax.validation.constraints.NotEmpty;

public class WaiterDto {

    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
