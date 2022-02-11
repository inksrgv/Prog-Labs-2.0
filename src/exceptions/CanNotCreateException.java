package exceptions;

public class CanNotCreateException extends RuntimeException{
    public CanNotCreateException(){
        super("Невозможно создать файл из-за неправильно введенного значения. Попробуйте другое значение");
    }
}
