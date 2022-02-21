package file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Класс, который позволяет пользователю и JVM осуществлять корректное чтение файла
 */
public class FileReader {

    public void read(){
        try {
            File file = new File("collection.csv");
            long l = file.length();
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            for(int i = 0; i<l; i++){
                int data = bis.read();
                System.out.print((char)data);
            }
            fis.close();
            bis.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}