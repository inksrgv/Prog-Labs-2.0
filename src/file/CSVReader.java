package file;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "D:/collection.csv";
//    public static void main(String[] args) throws IOException{
//        try {
//            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
//            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
//
//            for (CSVRecord csvRecord : parser){
//                //String initCollectionDate = csvRecord.get(0);
//               String  id = csvRecord.get(0);
//               String name = csvRecord.get(1);
//               String coordx = csvRecord.get(2);
//               String coordy = csvRecord.get(3);
//               String initDate = csvRecord.get(4);
//               String fromx = csvRecord.get(5);
//               String fromy = csvRecord.get(6);
//               String fromName = csvRecord.get(7);
//               String tox = csvRecord.get(8);
//               String toy = csvRecord.get(9);
//               String toName = csvRecord.get(10);
//               String distance = csvRecord.get(11);
//
//                System.out.println("record no:" + csvRecord.getRecordNumber() + " " + System.lineSeparator()+"id " + id + System.lineSeparator() + "name " + name + System.lineSeparator() + "coordinates (" + coordx + " " + coordy
//                + " )" + "location(from) ( " + fromx + " " + fromy + " " + fromName + " )" + System.lineSeparator() + "Location(to) ( " +
//                        tox + " " + toy + toName + " )" + System.lineSeparator() +
//                        "distance " + distance + System.lineSeparator() + "initialisation date " + initDate);
//
//
//            }
//        }catch(IOException e){
//            System.out.println(e.getMessage());
//        }
//    }

}
