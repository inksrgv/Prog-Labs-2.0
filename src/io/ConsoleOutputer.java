package io;


import utils.Route;

public class ConsoleOutputer implements  MessageHandler{

    public static void output(String msg) {System.out.println(msg); }
    public static void output(Route r){
        System.out.println(r.toString());
         }

}



