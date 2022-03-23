package file;

import java.util.Objects;

public class FileChecker {
    private FileSaver fileSaver = new FileSaver();

    public FileChecker(FileSaver fileSaver){
        this.fileSaver = fileSaver;
    }

    public boolean checkFileInList(String nameFile){
        for (String nameOfFile: fileSaver.getListOfFileNames()
             ) {
            if(Objects.equals(nameOfFile,nameFile)){
                return false;
            }
        }
        return true;
    }
}
