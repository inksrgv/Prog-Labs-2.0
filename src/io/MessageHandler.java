package io;
import utils.Route;

/**
 * Интерфейс для вывода на консоль
 */
public interface MessageHandler {
    static void output(String msg) {}
    static void output(Route route){}
}