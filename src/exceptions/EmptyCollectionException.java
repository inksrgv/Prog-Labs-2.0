package exceptions;

public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException(){
        super("Вы не можете очистить коллекцию, так как она не содержит элементов. Попробуйте использовать другую команду");
    }
}
