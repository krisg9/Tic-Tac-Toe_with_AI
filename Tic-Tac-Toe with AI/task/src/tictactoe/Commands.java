package tictactoe;

public enum Commands {
    START("start"),
    EXIT("exit");

    private String command;

    Commands(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return this.command;
    }
}
