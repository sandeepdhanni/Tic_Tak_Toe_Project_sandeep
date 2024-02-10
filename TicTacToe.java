
import java.util.Scanner;

public class TicTacToe{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Tic-Tac-Toe Game!!!");

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        printBoard(board);

        while (true) {
            playerTurn(board, scanner, 'X');
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);

            playerTurn(board, scanner, 'O');
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }

        scanner.close();

    }

    private static boolean isGameFinished(char[][] board) {

        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player X wins!");
            return true;
        }

        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Player O wins!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!!");
        return true;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        return board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol;
    }

    private static void playerTurn(char[][] board, Scanner scanner, char symbol) {
        String userInput;
        while (true) {
            System.out.println("Player " + symbol + ", where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move...");
            }
        }
        placeMove(board, userInput, symbol);
    }

    public static boolean isValidMove(char[][] board, String position) {
        int move = Integer.parseInt(position);
        if (move >= 1 && move <= 9) {
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            return board[row][col] == ' ';
        }
        return false;
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        int move = Integer.parseInt(position);
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = symbol;
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-+-+-");
            }
        }
    }
}
