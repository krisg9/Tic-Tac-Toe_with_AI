package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.printField();
        Computer cp = new Computer(); // computer oponent
        int counter = 0;
        do {
            if (counter % 2 == 0) {
                field.makeMove();
            } else {
                cp.makeMove(field);
            }
            counter++;
        } while (field.getState() == States.GAMENOTFINISHED);
    }
}
