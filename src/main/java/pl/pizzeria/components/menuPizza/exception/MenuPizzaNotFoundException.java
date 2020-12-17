package pl.pizzeria.components.menuPizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Cannot find object with provided id")
public class MenuPizzaNotFoundException extends RuntimeException {
}
