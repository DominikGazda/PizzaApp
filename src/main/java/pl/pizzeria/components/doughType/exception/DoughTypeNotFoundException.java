package pl.pizzeria.components.doughType.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Cannot find dough type with provided id")
public class DoughTypeNotFoundException extends RuntimeException {
}
