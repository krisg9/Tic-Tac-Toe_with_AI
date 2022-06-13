package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the cells: ");
        String input = scan.next();
        Field field = new Field(input);
        field.printField();
        field.makeMove();
    }
}
