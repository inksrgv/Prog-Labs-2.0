package file;

import dao.RouteDAO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Класс, который позволяет пользователю и JVM осуществлять корректное чтение файла
 */
public class FileReader {

    public void read(RouteDAO routeDAO){
        try {
            File file = new File("C:\\Users\\Софья\\OneDrive\\Рабочий стол\\collection.csv");
            long l = file.length();
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            fis.close();
            bis.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(routeDAO.getDescription().toString());
    }

}
