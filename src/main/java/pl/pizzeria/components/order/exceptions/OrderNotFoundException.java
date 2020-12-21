package pl.pizzeria.components.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Cannot find order with provided id")
public class OrderNotFoundException extends RuntimeException{
}
