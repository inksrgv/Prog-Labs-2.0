package exceptions;

public class InvalidCoordinateException extends Throwable{
    public InvalidCoordinateException() {super ("значение поля y должно быть больше -210");}
}
