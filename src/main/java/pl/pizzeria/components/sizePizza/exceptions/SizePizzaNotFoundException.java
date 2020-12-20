package pl.pizzeria.components.sizePizza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Cannot found pizza size with provided id")
public class SizePizzaNotFoundException extends RuntimeException{
}
