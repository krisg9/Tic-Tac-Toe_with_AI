package tictactoe;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Field {
    private char[][] field;
    private States state;
    private int numOfMoves = 0;

    // winning positions
    private int[][] winCondArr = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public Field() {
        this.field = new char[3][3];
        this.state = States.GAMENOTFINISHED;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';
            }
        }
        checkField('X');
        checkField('O');
    }

    public void printField() {
        System.out.print("---------\n");
        for (int i = 0; i < field.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("---------");
    }
    /* for Stage 0
    public char determineStarter() {
        int counterX = 0;
        int counterO = 0;
        for (int i = 0; i < initial.length(); i++) {
            if (initial.charAt(i) == 'X') {
                counterX++;
            } else if (initial.charAt(i) == 'O') {
                counterO++;
            }
        }
        return counterX > counterO ? 'O' : 'X';
    }
     */

    public States getState() {
        return state;
    }

    public void updateField(int x, int y, char symbol) {
        field[x - 1][y - 1] = symbol;
        numOfMoves++;
    }

    public boolean checkAvailability(int x, int y) {
        return field[x - 1][y - 1] == ' ';
    }

    public void printState() {
        System.out.println(this.state.toString());
    }

    public void updateState(States state) {
        this.state = state;
    }

    public int getNumOfMoves() {
        return numOfMoves;
    }

    // getting user input
    public void makeMove() {
        Scanner scan = new Scanner(System.in);
        boolean isRead;
        // input vars
        int inX, inY;
        do {
            try {
                System.out.print("\nEnter the coordinates: ");
                inX = scan.nextInt();
                inY = scan.nextInt();
                isRead = true;
                if (!checkAvailability(inX, inY)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    isRead = false;
                } else {
                    updateField(inX, inY, 'X');
                    printField();
                    checkField('X');
                    /* not needed because after X makes a move only X can
                       have a chance of winning */
                    // checkField('O');
                    System.out.println();
                    // printState(); - print stage only in Stage 0
                }
            } catch (InputMismatchException ime) {
                // clears buffer
                scan.nextLine();
                System.out.println("You should enter numbers!");
                isRead = false;
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                scan.nextLine();
                isRead = false;
                System.out.println("Coordinates should be from 1 to 3!");
            }
        } while (!isRead); // || state == States.GAMENOTFINISHED - only for Stage 1
        if (state == States.DRAW || state == States.O_WINS || state == States.X_WINS) {
            printState();
        }
    }

    // checking for winner
    public void checkField(char content) {
        // 2d field to 1d
        int[] currFieldIn1D = new int[field.length * field[0].length];
        int index1D = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                currFieldIn1D[index1D] = field[i][j];
                index1D++;
            }
        }

        /* go over win positions and check if one of them is currently in place
           update game state if needed
         */
        for (int i = 0; i < winCondArr.length; i++) {
            // index for 1D
            int index = 0;
            if (currFieldIn1D[winCondArr[i][0]] == content
                    && currFieldIn1D[winCondArr[i][1]] == content
                    && currFieldIn1D[winCondArr[i][2]] == content) {
                if (content == 'X') {
                    updateState(States.X_WINS);
                } else if(content == 'O') {
                    updateState(States.O_WINS);
                } else if (getNumOfMoves() == 9){
                    updateState(States.DRAW);
                } else {
                    updateState(States.GAMENOTFINISHED);
                }
            }
        }
    }
}
