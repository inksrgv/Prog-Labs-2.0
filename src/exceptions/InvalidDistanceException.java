package exceptions;

public class InvalidDistanceException extends RuntimeException{
    public InvalidDistanceException() {super ("поле не может быть меньше единицы");}
}
