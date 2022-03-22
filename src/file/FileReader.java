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

        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))
        ){
            int nextByte;
            while ((nextByte = inputStream.read()) != -1)
                bos.write((char) nextByte);

            input = bos.toString();

        }catch (IOException e) {
            return null;
        }

        List<String> lines = new ArrayList<String>(Arrays.asList(input.split(System.lineSeparator())));
        RouteDAO dao = new RouteDAO();
        try {
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                List<String> lineSplit = Arrays.asList(line.split(","));
                if (i == 0)
                {
                    //String type = lineSplit.get(1);
                    //String size = lineSplit.get(2);
                    dao.initDate = lineSplit.get(0);
                }
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


}
