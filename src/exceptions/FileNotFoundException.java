package exceptions;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException() {super ("такого файла не существует");}
}
