package utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Deque;

public class CollectionManager {
    public Deque<Route> collection = new ArrayDeque<>();
    public String initDate = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy : HH.mm.ss"));
    FileSaver fileSaver = new FileSaver();


}
