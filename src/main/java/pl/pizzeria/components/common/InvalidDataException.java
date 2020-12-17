package pl.pizzeria.components.common;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String message){
        super(message);
    }
}
