package file;
import dao.RouteDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import libraries.*;

/**
 * Класс, который позволяет пользователю и JVM осуществлять корректное чтение файла
 */
public class FileReader {
//TODO парашу окружения
    //public void read(RouteDAO routeDAO){
    /*
        try { написал егошин
            File csvData = new File("collection.csv");
            CSVParser parser = CSVParser.parse(csvData, CSVFormat.RFC4180);
            String pathToFile = System.getenv("PATH_TO_FILE");
            if (pathToFile == null || pathToFile.isEmpty()) {
                // переменной нет
            }

            File file = new File(pathToFile); тут заканчивается то что написал егошин
import java.file.FileWriter;
import au.com.bytecode.opencsv.CSVWriter;
/*
     */


    public void read(RouteDAO routeDAO) {
        try {
            File file = new File("C:\\Users\\Софья\\OneDrive\\Рабочий стол\\collection.csv");
            long l = file.length();
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            fis.close();
            bis.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(routeDAO.getDescription().toString());
    }
}

