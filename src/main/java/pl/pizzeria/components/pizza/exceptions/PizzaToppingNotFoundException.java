package pl.pizzeria.components.pizza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Cannot find pizza topping")
public class PizzaToppingNotFoundException extends RuntimeException{
}
