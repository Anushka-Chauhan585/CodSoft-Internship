import java.util.Scanner;

public class TicTacToeAI {
    private static final int SIZE = 3;
    private static final char EMPTY = '-';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board;
    private char currentPlayer;

    public TicTacToeAI() {
        board = new char[SIZE][SIZE];
        currentPlayer = PLAYER_X;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean isMoveValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == EMPTY;
    }

    private boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void makeAIMove() {
        // First, check if AI can win
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = currentPlayer;
                    if (checkWin(currentPlayer)) {
                        return;
                    }
                    board[i][j] = EMPTY;
                }
            }
        }

        // Then, check if player can win and block
        char opponent = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = opponent;
                    if (checkWin(opponent)) {
                        board[i][j] = currentPlayer;
                        return;
                    }
                    board[i][j] = EMPTY;
                }
            }
        }

        // If neither can win, just make a random move
        while (true) {
            int row = (int) (Math.random() * SIZE);
            int col = (int) (Math.random() * SIZE);
            if (board[row][col] == EMPTY) {
                board[row][col] = currentPlayer;
                break;
            }
        }
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();

            if (currentPlayer == PLAYER_X) {
                System.out.println("Player X's turn:");
                System.out.print("Enter row and column (0-2): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isMoveValid(row, col)) {
                    board[row][col] = PLAYER_X;
                    currentPlayer = PLAYER_O;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } else {
                System.out.println("Player O's turn (AI):");
                makeAIMove();
                currentPlayer = PLAYER_X;
            }

            if (checkWin(PLAYER_X)) {
                printBoard();
                System.out.println("Player X wins!");
                gameEnded = true;
            } else if (checkWin(PLAYER_O)) {
                printBoard();
                System.out.println("Player O wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToeAI game = new TicTacToeAI();
        game.play();
    }
}
