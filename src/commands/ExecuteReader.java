package commands;

import java.util.ArrayList;
import java.util.List;

public class ExecuteReader {
    static public List<String> listOfNamesOfScripts = new ArrayList<>();
    static public boolean checkNameOfFileInList(String nameOfFile){
        for (String name: listOfNamesOfScripts

        ) {
            if (name.equals(nameOfFile)){
                return false;
            }
        }
        return true;
    }

}
