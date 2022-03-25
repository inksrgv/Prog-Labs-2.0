package file;

import dao.RouteDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import utils.Route;
import utils.RouteInfo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Класс, который позволяет пользователю и JVM осуществлять корректное чтение файла
 */
public class CSVFileReader {
    private static String nameOfFile = System.getenv().get("collection.csv");
    private static final String TEMP_FILE = "C:/collection_temp.csv";
    public RouteDAO read() {
        File file = new File(nameOfFile);
        String input = " ";
        if (!file.exists()) {
            try {
                if(!file.createNewFile()){
                    System.out.println("Чтение временного файла");
                    CSVFileReader.nameOfFile = TEMP_FILE;
                    file = new File(nameOfFile);
                }
//                System.out.println("Файл не создан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            int nextByte;
            while ((nextByte = inputStream.read()) != -1)
                bos.write((char) nextByte);

            input = bos.toString();

        }catch (IOException e) {
//            FileWriter.createTmpFile();
            return new RouteDAO();
        }

        List<String> lines = new ArrayList<String>(Arrays.asList(input.split(System.lineSeparator())));
        RouteDAO dao = new RouteDAO();
        try {
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                List<String> lineSplit = Arrays.asList(line.split(","));
                if (i == 0)
                    dao.initDate = lineSplit.get(0);

                else {
                    RouteInfo info = new RouteInfo(lineSplit);
                    dao.create(new Route(info));
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new RouteDAO();
        }
        return dao;
    }

    //private static final String SAMPLE_CSV_FILE_PATH = "D:/test/collection.csv";
/*
    public String readCSV(){
        RouteDAO dao = new RouteDAO();
        Map<String, String> listOfEnvs = System.getenv();
        String nameOfFile = listOfEnvs.get("collection.csv");
        File file = new File(nameOfFile);
        String input = " ";
        if (!file.exists()) {
            try {
                if(!file.createNewFile())
                    System.out.println("Файл не создан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String output = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            for (CSVRecord csvRecord : parser){
                //String initCollectionDate = csvRecord.get(0);
                String  id = csvRecord.get(0);
                String name = csvRecord.get(1);
                String coordx = csvRecord.get(2);
                String coordy = csvRecord.get(3);
                String initDate = csvRecord.get(4);
                String fromx = csvRecord.get(5);
                String fromy = csvRecord.get(6);
                String fromName = csvRecord.get(7);
                String tox = csvRecord.get(8);
                String toy = csvRecord.get(9);
                String toName = csvRecord.get(10);
                String distance = csvRecord.get(11);

                //output = ("record no:" + csvRecord.getRecordNumber() + " " + System.lineSeparator()+"id " + id + System.lineSeparator() + "name " + name + System.lineSeparator() + "coordinates (" + coordx + " " + coordy
                  //      + " )" + "location(from) ( " + fromx + " " + fromy + " " + fromName + " )" + System.lineSeparator() + "Location(to) ( " +
                    //    tox + " " + toy + toName + " )" + System.lineSeparator() +
                      //  "distance " + distance + System.lineSeparator() + "initialisation date " + initDate);
               // RouteInfo info = new RouteInfo(Integer.parseInt(id), name, Double.parseDouble(coordx), Double.parseDouble(coordy), ZonedDateTime.parse(initDate),
                 //       Double.parseDouble(fromx), Long.parseLong(fromy), fromName, Integer.parseInt(tox), Long.parseLong(toy), toName, Integer.parseInt(distance));
                //dao.create(new Route(info));
                output = "initialisation date " + initDate;
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        return output;
    }*/
}
