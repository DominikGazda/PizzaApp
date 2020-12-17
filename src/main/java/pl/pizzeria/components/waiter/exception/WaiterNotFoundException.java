package pl.pizzeria.components.waiter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Cannot find object with provided id")
public class WaiterNotFoundException extends RuntimeException{
}
