package tictactoe;

public enum States {
    GAMENOTFINISHED("Game not finished"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins");

    String description;

    States(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
