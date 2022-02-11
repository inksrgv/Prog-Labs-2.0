package exceptions;

public class CannotClearCollectionException extends RuntimeException{
    public CannotClearCollectionException() {super("коллекция уже пустая. ее невозможно очистить");}
}
