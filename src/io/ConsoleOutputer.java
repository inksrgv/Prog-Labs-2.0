package io;
import utils.Route;

/**
 * Класс имплементируемый от интерфейса MessageHandler, который позволяет выводить корректные сообщения пользователю на консоль.
 */
public class ConsoleOutputer implements MessageHandler{
    public static void output(String msg) {System.out.println(msg); }
    public static void output(Route r){
        System.out.println(r.toString()); //надо посмотреть, мб стоит еще переопределить тустринг
    }

}
