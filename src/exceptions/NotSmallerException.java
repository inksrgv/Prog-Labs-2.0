package exceptions;

public class NotSmallerException extends RuntimeException{
    public NotSmallerException(){
        super("Некорректный ввод. Добавление в коллекцию невозможно, так как элемент не является наименьшим. Введите другое значение");
    }
}
