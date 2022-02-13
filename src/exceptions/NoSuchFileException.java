package exceptions;

public class NoSuchFileException extends RuntimeException{
    public NoSuchFileException(){
        super("невозможно считать и исполнить скрипт из указанного файла, так как не сущетсвует указанного файла. Введите другое имя файла.");
    }
}
