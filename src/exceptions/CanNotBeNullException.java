package exceptions;

public class CanNotBeNullException extends RuntimeException{
    public CanNotBeNullException(){
        super("Элемент не может принимать нулевое значение. ВВедите другое значение.");
    }
}
