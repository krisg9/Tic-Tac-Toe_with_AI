package tictactoe;

public class Computer {
    private final char SYMBOL = 'O';

    public void makeMove(Field field) {
        int x = (int) ((Math.random() * 3) + 1);
        int y = (int) ((Math.random() * 3) + 1);
        if (field.checkAvailability(x, y)) {
            field.updateField(x,y, 'O');
            field.printField();
            field.checkField('O');
            System.out.println();
            field.printState();
        }
    }
}
