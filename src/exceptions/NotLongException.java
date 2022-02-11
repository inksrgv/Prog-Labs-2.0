package exceptions;

public class NotLongException extends RuntimeException{
    public NotLongException(){
        super("Некорректный ввод, длина не может быть меньше единицы. Ввведите другое значение.");
    }
}
