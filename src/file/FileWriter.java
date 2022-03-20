package file;

import dao.DAO;
import dao.RouteDAO;
import utils.Route;
import utils.RouteInfo;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Класс, который позволяет осуществлять корректную запись данных в файл
 */
public class FileWriter {
    File file = new File("C:\\Users\\Софья\\OneDrive\\Рабочий стол\\collection.csv");
    /**
     * Метод записи данных о коллекции в файл
     * @param routeDAO
     */
    public void write(RouteDAO routeDAO)  {
        try{
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);

            String toBeWritten = (routeDAO.getDescription().toString());

            fos.write(toBeWritten.getBytes(StandardCharsets.UTF_8));

            fos.flush();
            fos.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void clear(){
        file.delete();
    }
}
