package tictactoe;

public class Computer {
    private final char SYMBOL = 'O';

    public void makeMove(Field field) {
        int x;
        int y;
        // find free space on field
        do {
            x = (int) ((Math.random() * 3) + 1);
            y = (int) ((Math.random() * 3) + 1);
        } while (!field.checkAvailability(x, y));

        // place O on field
        field.updateField(x,y, SYMBOL);
        System.out.println("Making move level \"easy\"");
        field.printField();
        field.checkField(SYMBOL);
        System.out.println();
        // field.printState(); - print stage only in Stage 0
        if (field.getState() == States.DRAW
                || field.getState() == States.O_WINS
                || field.getState() == States.X_WINS) {
            field.printField();
            field.printState();
        }
    }
}
