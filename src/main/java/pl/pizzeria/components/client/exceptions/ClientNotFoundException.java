package pl.pizzeria.components.client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND,reason = "Cannot find client with provided id")
public class ClientNotFoundException extends RuntimeException{
}
