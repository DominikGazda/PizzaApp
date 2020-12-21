package pl.pizzeria.components.toppings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cannot found topping with provided id")
public class ToppingsNotFoundException extends RuntimeException{
}
