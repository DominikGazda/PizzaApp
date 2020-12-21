package pl.pizzeria.components.waiter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Cannot find waiter with provided id")
public class WaiterNotFoundException extends RuntimeException{
}
