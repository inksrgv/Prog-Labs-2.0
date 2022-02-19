package io;

import commands.CommandsCover;
import utils.Coordinates;
import utils.Route;
import exceptions.InvalidDataException;
import exceptions.InvalidNumberException;

import java.time.LocalDate;
import java.util.Scanner;
import src.exceptions.*;

    public interface InputManager {
        /**
         * reads name from input
         *
         * @return
         * @throws EmptyStringException
         */
        String readName() throws EmptyStringException;

        /**
         * reads fullName from input
         *
         * @return
         */
        String readFullName();

        /**
         * reads x from input
         *
         * @return
         * @throws InvalidNumberException
         */
        double readXCoordinate() throws InvalidNumberException;

        /**
         * reads y from input
         *
         * @return
         * @throws InvalidNumberException
         */

        Double readYCoordinate() throws InvalidNumberException;

        /**
         * reads coordinates from input
         *
         * @return
         * @throws InvalidNumberException
         */
        Coordinates readCoords() throws InvalidNumberException;


        /**
         * reads Worker from input
         *
         * @return
         * @throws InvalidDataException
         */

        Route readRoute() throws InvalidDataException;

        /**
         * reads command-argument pair from input
         *
         * @return
         */
        public CommandsCover readCommand();

/**
 * gets input scanner
 * @return
 */
    }
}
