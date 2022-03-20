package file;
import dao.RouteDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import libraries.*;
import java.util.Arrays;

/**
 * Класс, который позволяет пользователю и JVM осуществлять корректное чтение файла
 */
// чтение всего файла и вывод на консоль
    public class FileReader
    {
        @SuppressWarnings("resource")
        public static void main(String[] args) throws Exception
        {
                CSVReader reader = new CSVReader(new FileReader("collection.csv"), ',', '"', 1);
                List<String[]> allRows = reader.readAll();
                for(String[] row : allRows){
                    System.out.println(Arrays.toString(row));
                }
            }

    //import com.opencsv.CSVReader;
//            import com.opencsv.CSVWriter;
//            import com.opencsv.exceptions.CsvException;
//            import java.io.FileNotFoundException;
//            import java.io.FileReader;
//            import java.io.FileWriter;
//            import java.io.IOException;
//            import java.util.Arrays;
//            import java.util.List;
//
//public class CSVLibrary {
//    public static void main (String args[])  {
//        CSVLibrary csvLibrary =  new CSVLibrary();
//        csvLibrary.writeToCsv();
//        csvLibrary.readCSVFile();
//    }
//    public void writeToCsv(){
//        String csv = "data.csv";
//        try{
//            CSVWriter writer = new CSVWriter(new FileWriter(csv));
//            String [] record = "2,Virat,Kohli,India,30".split(",");
//            writer.writeNext(record);
//
//            writer.close();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void readCSVFile(){
//        CSVReader reader = null;
//        try {
//            reader = new CSVReader(new FileReader("data.csv"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        List<String[]> allRows = null;
//        try {
//            allRows = reader.readAll();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (CsvException e) {
//            e.printStackTrace();
//        }
//
//        for(String[] row : allRows){
//            System.out.println(Arrays.toString(row));
//        }
//    }
//}
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

