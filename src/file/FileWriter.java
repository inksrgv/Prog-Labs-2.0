package file;

import dao.RouteDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import libraries.*;

/**
 * Класс, который позволяет осуществлять корректную запись данных в файл
 */
public class FileWriter {
        public static void main(String[] args)
        {
            File file = new File("C:\\Users\\Софья\\OneDrive\\Рабочий стол\\collection.csv");
            CSVWriter writer = new CSVWriter(new FileWriter(csv));
            CSVParser parser = CSVParser.parse(csvData, CSVFormat.RFC4180);
            String pathToFile = System.getenv("C:\\Users\\Софья\\OneDrive\\Рабочий стол\\collection.csv");
            if !(pathToFile == null || pathToFile.isEmpty()) {
            //Create record
            String [] record = dao.RouteDAO.collection;
            //Write the record to file
            writer.writeNext(record);
            //close the writer
            writer.close();
        }
    }

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
