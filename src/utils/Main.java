package utils;

import dao.RouteDAO;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RouteDAO dao = new RouteDAO();
        Scanner sc = new Scanner(System.in);
        RouteInfo out = new RouteInfo();

        Commands.AddElement add = new Commands.AddElement();
        Console console = new Console();
        add.execute(dao);


    }
}