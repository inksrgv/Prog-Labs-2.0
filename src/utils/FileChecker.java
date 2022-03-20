package utils;
import dao.RouteDAO;

public class FileChecker {
    private  FileSaver fileSaver = new FileSaver();

    public FileChecker(FileSaver fileSaver){
        this.fileSaver = fileSaver;
    }

    public boolean checkFileInList(String nameFile){
        for (String nameOfFile: fileSaver.getListOfFileNames()
             ) {
            if(Object.equals(nameOfFile,nameFile)){
                return false;
            }
        }
        return true;
    }
}
