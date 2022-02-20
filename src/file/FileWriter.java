package file;

import dao.DAO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileWriter {
    public void write(DAO collection)  {
        File file = new File("collection.csv");
        try{
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);

            String toBeWritten = String.valueOf(collection.getDescription());

            fos.write(toBeWritten.getBytes(StandardCharsets.UTF_8));

            fos.flush();
            fos.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
