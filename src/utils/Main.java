package utils;

import dao.RouteDAO;
import file.FileReader;
import file.FileWriter;

public class Main {
    public static void main(String[] args) {

        //Commands.runApp();

        RouteDAO newDao = new FileReader().read();

        System.out.println(newDao.getDescription());
    }
}