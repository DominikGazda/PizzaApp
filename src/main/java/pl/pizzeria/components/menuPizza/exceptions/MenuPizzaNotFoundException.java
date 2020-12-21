package pl.pizzeria.components.menuPizza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cannot find menu pizza with provided id")
public class MenuPizzaNotFoundException extends RuntimeException {
}
