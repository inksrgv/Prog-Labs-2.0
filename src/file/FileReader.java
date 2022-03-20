package file;

import dao.RouteDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Класс, который позволяет пользователю и JVM осуществлять корректное чтение файла
 */
public class FileReader {
//TODO парашу окружения
    public void read(RouteDAO routeDAO){
        Map<String,String> listOfEnvs = System.getenv();
        String nameOfFile = list.get("USERNAME");
    }
}
