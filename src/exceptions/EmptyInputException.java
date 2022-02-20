package exceptions;

public class EmptyInputException extends RuntimeException{
    public EmptyInputException(){
        super("пустой ввод");
    }
}
