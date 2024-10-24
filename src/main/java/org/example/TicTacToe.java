package org.example;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;

    // Constructor to initialize a 3x3 board with '_' and set the first player as 'X'
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        // Initialize board with '_'
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    // Let a player choose a move at the given row and column
    public boolean choose(int row, int column) {
        if (row < 0 || row > 2 || column < 0 || column > 2 || board[row][column] != '_') {
            return false;
        }
        board[row][column] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
        return true;
    }

    // Return the next player (either 'X' or 'O')
    public char getNextPlayerChar() {
        return currentPlayer;
    }

    // Return a textual version of the tic tac toe board
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Get the current state of the game board
    public char[][] getCharArray() {
        return board;
    }

    // Check if a player has won by checking rows, columns, and diagonals
    public boolean didWin(char playerChar) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == playerChar && board[i][1] == playerChar && board[i][2] == playerChar) {
                return true;
            }
            if (board[0][i] == playerChar && board[1][i] == playerChar && board[2][i] == playerChar) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == playerChar && board[1][1] == playerChar && board[2][2] == playerChar) {
            return true;
        }
        if (board[0][2] == playerChar && board[1][1] == playerChar && board[2][0] == playerChar) {
            return true;
        }
        return false;
    }

    // Check if the game is tied
    public boolean didTie() {
        if (!notDone() && !didWin('X') && !didWin('O')) {
            return true;
        }
        return false;
    }

    // Check if the game is not done (there are more possible moves)
    public boolean notDone() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("X will start. Enter row and column (0-2) for your move.");

        while (game.notDone()) {
            System.out.println(game);
            System.out.println("Current player: " + game.getNextPlayerChar());

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!game.choose(row, col)) {
                System.out.println("Invalid move, try again.");
            } else {
                if (game.didWin('X')) {
                    System.out.println("Congratulations! X wins!");
                    break;
                } else if (game.didWin('O')) {
                    System.out.println("Congratulations! O wins!");
                    break;
                } else if (game.didTie()) {
                    System.out.println("It's a tie!");
                    break;
                }
            }
        }

        System.out.println("Final board:");
        System.out.println(game);
        scanner.close();
    }
}