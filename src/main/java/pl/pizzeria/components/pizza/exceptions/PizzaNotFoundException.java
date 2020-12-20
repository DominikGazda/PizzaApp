package pl.pizzeria.components.pizza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cannot find pizza with provided id")
public class PizzaNotFoundException extends RuntimeException{
}
