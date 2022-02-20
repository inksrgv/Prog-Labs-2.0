package utils;

import exceptions.EmptyInputException;
import exceptions.InvalidDistanceException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface RouteInformation {
    RouteInfo info();
}

class Console implements RouteInformation{

    public RouteInfo info() {
        Scanner sc = new Scanner(System.in);
        RouteInfo out = new RouteInfo();

        System.out.println("Введите название маршрута, не может быть пустым ");
        while (true) {
            try {
                out.name = sc.nextLine();
                if (out.name.isEmpty()) {
                    System.out.println("название не может быть пустым");
                    continue;}
                break;
            } catch (RuntimeException e) {
                System.out.println("введите строку");
            }
        }

        System.out.println("Введите координату x (double), маршрута");
        while (true) {
            try {
                out.x = sc.nextDouble();
                break;
            }
            catch (RuntimeException e) {
                System.out.println("введите данные типа double");
            }

        System.out.println("Введите координату y (Double, >-210, не может быть null), маршрута");
        while (true) {
            try {
                out.y = sc.nextDouble();
                if (out.y <= -210) {
                    System.out.println("значение y должно быть больше -210");
                    continue;
                }
                break;
            } catch (RuntimeException e) {
                System.out.println("введите данные типа Double");
            }
        }

            System.out.println("Введите точку отправления Х, double");
            while (true) {
                try {
                    out.fromX = sc.nextDouble();
                    break;
                } catch (RuntimeException e) {
                    System.out.println("введите данные типа double");
                }
            }

            System.out.println("Введите точку отправления У,Long (поле не может быть null)");
            while (true) {
                try {
                    out.fromY = sc.nextLong();
                    if (out.fromY == null)
                    {
                        System.out.println("поле не может быть пустым");
                    }
                        break;
                } catch (RuntimeException e) {
                    System.out.println("введите данные типа Long");
                }
            }

            System.out.println("Введите название точки отправления, String");
            while (true) {
                try {
                    out.nameFrom = sc.nextLine();
                    if (out.nameFrom.isEmpty()) {
                        System.out.println("название не может быть пустым");
                        continue;
                    }
                    break;
                } catch (RuntimeException e) {
                    System.out.println("введите строку");
                }
            }

            System.out.println("Введите точку прибытия Х,int");
            while (true) {
                try {
                    out.toX = sc.nextInt();
                    break;
                } catch (RuntimeException e) {
                    System.out.println("введите данные типа int");
                }
            }
            System.out.println("Введите точку прибытия У,float");
            while (true) {
                try {
                    out.toY = sc.nextFloat();
                    break;
                } catch (RuntimeException e) {
                    System.out.println("введите данные типа float");
                }
            }

            System.out.println("Введите название точки прибытия, String");
            while (true) {
                try {
                    out.nameTo = sc.nextLine();
                    if (out.nameTo.isEmpty()) {
                        System.out.println("название не может быть пустым");
                        continue;
                    }
                    break;
                } catch (RuntimeException e) {
                    System.out.println("введите строку");
                }
            }

            System.out.println("Введите длину расстояния, Integer");
            while (true) {
                try {
                    out.distance = sc.nextInt();
                    if (out.distance < 1) {
                        throw new InvalidDistanceException();
                    }
                    break;
                } catch (RuntimeException e) {
                    System.out.println("введите данные типа int");
                }
            }
        }
        return out;
    }
}

//TODO скорее всего беды с командами Add, UpdateById, RemoveById связаны с этим убожищем
//видимо беды из-за другого
class ConsoleReader {
    public List<String> reader(){
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        if (command.isEmpty()){
            throw new EmptyInputException();
        }
        List<String> args = new ArrayList<>(Arrays.asList(command.split(" ")));

        /*for (int i = 0; i < args.size(); i++){
            System.out.println(args.get(i));
        }*/

        return args;
    }
}

