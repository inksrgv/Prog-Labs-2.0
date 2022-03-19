package utils;

import exceptions.EmptyInputException;

import java.util.*;

public interface RouteInformation {
    RouteInfo info();
}

class Console implements RouteInformation{

    Scanner sc = new Scanner(System.in);
    RouteInfo out = new RouteInfo();
    //List<RouteInfo> routeInfos = new ArrayList<>();

    public RouteInfo info() {

        System.out.println("Введите название маршрута, не может быть пустым ");
        while (true) {
            try {
                out.name = sc.nextLine().trim();
                if (out.name.isEmpty()) {
                    System.out.println("название не может быть пустым");
                    continue;}
                break;
            } catch (RuntimeException e) {
                System.out.println("введите строку");
            }
        }
        System.out.println("введите координату Х маршрута (double)");
        while(true){
            try{
                out.x = Double.parseDouble(sc.nextLine());
                break;
            }
            catch (RuntimeException e){
                System.out.println("введен неправильный тип данных");

            }
        }
        System.out.println("введите координату У маршрута (Double), >-210");
        while(true){
            try{
                out.y = Double.parseDouble(sc.nextLine());
                if (out.y < -210){
                    System.out.println("неверный ввод");
                }
                else {
                    break;
                }
            }
            catch (RuntimeException e){
                System.out.println("введен неправильный тип данных");
            }
        }
        System.out.println("введите точку отправления Х (double)");
        while(true){
            try{
                out.fromX = Double.parseDouble(sc.nextLine());
                break;
            }
            catch (RuntimeException e){
                System.out.println("введен неправильный тип данных");
            }
        }
        System.out.println("введите точку отправления У (Long)");
        while(true){
            try{
                out.fromY = Long.parseLong(sc.nextLine());
                break;
            }
            catch (RuntimeException e){
                System.out.println("введен неправильный тип данных");
            }
        }

        System.out.println("Введите название точки отправления ");
        while (true) {
            try {
                out.nameFrom = sc.nextLine();
                if (out.nameFrom.isEmpty()) {
                    System.out.println("название не может быть пустым");
                    continue;}
                break;
            } catch (RuntimeException e) {
                System.out.println("введите строку");
            }
        }

        System.out.println("введите точку прибытия Х, (int)");
        while(true){
            try{
                out.toX = Integer.parseInt(sc.nextLine());
                break;
            }
            catch (RuntimeException e){
                System.out.println("введен неправильный тип данных");
            }
        }

        System.out.println("введите точку прибытия У (float)");
        while(true){
            try{
                out.toY = Float.parseFloat(sc.nextLine());
                break;
            }
            catch (RuntimeException e){
                System.out.println("неправильный ввод данных");
            }
        }
        System.out.println("введите название точки прибытия");
        while(true){
            try{
                out.nameTo = sc.nextLine();
                break;
            }
            catch (RuntimeException e){
                System.out.println("неправильный ввод");
            }
        }
        System.out.println("введите длину маршрута (int), >1");
        while(true){
            try{
                out.distance =Integer.parseInt(sc.nextLine());
                if(out.distance < 0 || out.distance < 1){
                    System.out.println("длина маршрута должна быть больше 1");
                    continue;
                }
                break;
            }
            catch (RuntimeException e){
                System.out.println("неправильный тип данных");
            }
        }
        return  out;
    }

}


class ConsoleReader {
    public List<String> reader(){
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine().trim();

        if (command.isEmpty()){
            throw new EmptyInputException();
        }
        List<String> args = new ArrayList<>(Arrays.asList(command.split(" ")));
        return args;

    }

}

