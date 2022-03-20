package io;

import utils.Route;

public interface MessageHandler {
    String executeScript(String fileName);
    static void output(String msg) {}
    static void output(Route route){}
}
