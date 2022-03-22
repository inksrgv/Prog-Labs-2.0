package utils;
import java.util.ArrayList;
public class FileSaver {

    private final ArrayList<String> listOfFileNames = new ArrayList<>();
    public void save(String nameOfFile){
        this.listOfFileNames.add(nameOfFile);
    }
    public ArrayList<String> getListOfFileNames(){
        return this.listOfFileNames ;
    }
}
