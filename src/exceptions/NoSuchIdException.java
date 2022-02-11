package exceptions;

public class NoSuchIdException extends RuntimeException{
    public NoSuchIdException(){super("нет такого id");}
}
