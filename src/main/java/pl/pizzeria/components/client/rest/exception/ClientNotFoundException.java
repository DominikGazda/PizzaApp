package pl.pizzeria.components.client.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND,reason = "client with that id not found")
public class ClientNotFoundException extends RuntimeException{
}
