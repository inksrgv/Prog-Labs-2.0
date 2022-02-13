package exceptions;

public class WrongPermissionException extends RuntimeException{
    public WrongPermissionException() {super ("невозможно прочитать файл");}
}
