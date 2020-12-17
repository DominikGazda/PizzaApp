package pl.pizzeria.components.toppings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Cannot found object with provided id")
public class ToppingsNotFoundException extends RuntimeException{
}
