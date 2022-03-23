package console;

import exceptions.EmptyInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {
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
