package io;

import exceptions.EmptyCollectionException;
import exceptions.InvalidDataException;
import exceptions.InvalidNumberException;
import utils.Coordinates;
import utils.Route;
import utils.loc.*;
import lab5.exceptions.src.commands.CommandsCover;
import java.time.LocalDate;
import lab5.exceptions.src.exceptions.*;
import java.util.Scanner;
/**
 * basic implementation of InputManager
 */
public abstract class InputManagerI implements InputManager{
    private Scanner scanner;
    public InputManagerI(Scanner sc){
        scanner = sc;
        scanner.useDelimiter("\n");
    }

    public Scanner getScanner(){
        return scanner;
    }

    public void setScanner(Scanner sc){
        scanner = sc;
    }
    public String readName() throws EmptyCollectionException {
        String s = scanner.nextLine().trim();
        if (s.equals("")){
            throw new EmptyCollectionException();
        }
        return s;
    }

    Scanner sc = new Scanner(System.in);

    public String readFullName(){
        String s = scanner.nextLine().trim();
        if (s.equals("")){
            return null;
        }
        return s;
    }

    public double readXCoordinate() throws InvalidNumberException{
        double x;
        try{
            x = Double.parseDouble(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        if (Double.isInfinite(x) || Double.isNaN(x)) throw new InvalidNumberException("invalid double value");
        return x;
    }

    public Double readYCoordinate() throws InvalidNumberException{
        Double y;
        try{
            y = Double.parseDouble(scanner.nextLine());
        }
        catch(NumberFormatException e){
            throw new InvalidNumberException();
        }
        if (y<=-210) throw new InvalidNumberException("must be greater than -210");
        return y;
    }

    public Coordinates readCoords() throws InvalidNumberException{
        double x = readXCoordinate();
        Double y = readYCoordinate();
        Coordinates coordinates = new Coordinates(x,y);
        return coordinates;
    }

    public String readLocationFrom(){
        String from = scanner.nextLine().trim();
        if (from.equals("")){
            return null;
        }
        return from;
    }

    public String readLocationTo(){
        String to = scanner.nextLine().trim();
        if (to.equals("")){
            return null;
        }
        return to;
    }

    public Route readRoute() throws InvalidDataException{
        Route route = null;
        String name = readName();
        Coordinates coords = readCoords();
        Location from = readLocationFrom();
        Location to = readLocationTo();
        route = new Route(name, coords, from, to);

        return route;
    }
}

