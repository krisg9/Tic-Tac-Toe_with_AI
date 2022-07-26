package tictactoe;

import java.awt.geom.AffineTransform;
import java.security.cert.CertificateParsingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* STAGE 2
        Field field = new Field();
        field.printField();
        Computer cp = new Computer(field); // computer oponent
        int counter = 0;
        do {
            if (counter % 2 == 0) {
                field.makeMove();
            } else {
                cp.makeMove();
            }
            counter++;
        } while (field.getState() == States.GAMENOTFINISHED);
         */
        // STAGE 3
        run();
    }

    private static void start(String[] commands) {
        Field field = new Field();
        // configure game for input string
        Player first;
        Player second;
        if (commands[1].compareTo("user") == 0 && commands[2].compareTo("user") == 0) {
            first = new HumanPlayer(field);
            second = new HumanPlayer(field);
        } else if (commands[1].compareTo("user") == 0 && commands[2].compareTo("easy") == 0) {
            first = new HumanPlayer(field);
            second = new Computer(field);
        } else if (commands[1].compareTo("easy") == 0 && commands[2].compareTo("user") == 0) {
            first = new HumanPlayer(field);
            second = new Computer(field);
        } else if (commands[1].compareTo("easy") == 0 && (commands[2].compareTo("easy") == 0)) {
            first = new Computer(field);
            second = new Computer(field);
        } else {
            System.out.println("Bad parameters!");
            return;
        }
        first.setSymbol('X');
        second.setSymbol('O');
        field.printField();
        System.out.println();
        while (field.getState() == States.GAMENOTFINISHED) {
            first.makeMove();
            if (field.getState() != States.GAMENOTFINISHED) {
                break;
            }
            second.makeMove();
        }
    }

    public static void run() {
        Scanner scan = new Scanner(System.in);
        boolean running = true;
        do {
            System.out.println("Input command: ");
            String input = scan.nextLine();
            String[] commands = input.trim().split(" ");
            if (commands.length == 3) {
                // program goes on
                start(commands);
                running = false;
            } else {
                // exit command rechedif
                if (input.compareTo(Commands.EXIT.toString()) == 0) {
                    running = false;
                } else { // bad parameters
                    System.out.println("Bad parameters!");
                }
            }
        } while (running);
    }
}
