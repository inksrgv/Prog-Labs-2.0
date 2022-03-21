package file;

import dao.RouteDAO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import utils.Route;
import utils.RouteInfo;

import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Класс, который позволяет пользователю и JVM осуществлять корректное чтение файла
 */
public class FileReader {
    //TODO парашу окружения
    public RouteDAO read() {
        Map<String, String> listOfEnvs = System.getenv();
        String nameOfFile = listOfEnvs.get("collection.csv");
        String input = null;
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            FileInputStream fileInputStream = new FileInputStream(nameOfFile);
            BufferedInputStream inputStream = new BufferedInputStream(fileInputStream)
        ){
            int nextByte;
            while ((nextByte = inputStream.read()) != -1)
                bos.write((char) nextByte);

            input = bos.toString();
        }catch (IOException e) {
            // todo
            return null;
        }
        List<String> lines = new ArrayList<String>(Arrays.asList(input.split(System.lineSeparator())));
        RouteDAO dao = new RouteDAO();
        try {
            for (String line : lines) {
                List<String> lineSplit = Arrays.asList(line.split(","));
                RouteInfo info = new RouteInfo(lineSplit);
                dao.create(new Route(info));
                dao.initDate = lineSplit.get(12);
            }
        } catch (RuntimeException e) {
            return new RouteDAO();
        }

        return dao;
    }
}
