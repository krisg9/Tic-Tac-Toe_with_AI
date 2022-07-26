package tictactoe;

public class Computer implements Player{
    private char symbol;
    private Field field;
    public Computer(Field field) {
        this.field = field;
    }
    public void makeMove() {
        int x;
        int y;
        // find free space on field
        do {
            x = (int) ((Math.random() * 3) + 1);
            y = (int) ((Math.random() * 3) + 1);
        } while (!field.checkAvailability(x, y));

        // place O on field
        field.updateField(x,y, symbol);
        System.out.println("Making move level \"easy\"");
        field.printField();
        field.checkField(symbol);
        System.out.println();
        // field.printState(); - print stage only in Stage 0
        if (field.getState() == States.DRAW
                || field.getState() == States.O_WINS
                || field.getState() == States.X_WINS) {
            field.printState();
        }
    }

    public void setSymbol(char SYMBOL) {
        this.symbol = SYMBOL;
    }
}
