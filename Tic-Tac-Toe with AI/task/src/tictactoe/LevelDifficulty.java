package tictactoe;

public enum LevelDifficulty {
    EASY("easy");

    String difficulty;

    LevelDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return this.difficulty;
    }
}
