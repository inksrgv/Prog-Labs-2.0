package utils;

import dao.RouteDAO;

public class IdGenerator {
    private static int id;
    public static void reloadId(RouteDAO dao) {
        id = dao.getMaxId();
    }
    public static int nextId(){
        return ++id;
    }
}
