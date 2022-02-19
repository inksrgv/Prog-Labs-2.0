package file;

import dao.DAO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileSaver implements FileManager{

    @Override
    public DAO get() {
        return null;
    }

    @Override
    public void save(DAO collection)  {
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
