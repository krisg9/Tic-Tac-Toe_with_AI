package tictactoe;

public class HumanPlayer implements Player {
    private char symbol;
    private Field field;

    public HumanPlayer(Field field) {
        this.field = field;
    }

    // human player calls make move which is already implemented in field
    public void makeMove() {
       field.makeMove();
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}