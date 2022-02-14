package exceptions;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException() {super ("файла с таким path не существует ");}
}
