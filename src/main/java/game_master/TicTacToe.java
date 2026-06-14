package game_master;

import java.util.Scanner;

import main_game_package.BoardInterface;
import main_game_package.PlayerInterface;
import main_game_package.TicTacToeInterface;

public class TicTacToe implements TicTacToeInterface {

    private PlayerInterface player1;
    private PlayerInterface player2;
    private PlayerInterface currentPlayer;
    private final BoardInterface board;
    private final char[][] moves;
    private final Scanner scanner;

    public TicTacToe(PlayerInterface player1, PlayerInterface player2, BoardInterface board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.moves = new char[3][3];
        this.scanner = new Scanner(System.in);
        init();
    }

    public TicTacToe(PlayerInterface player1, PlayerInterface player2, BoardInterface board, Scanner scanner) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.moves = new char[3][3];
        this.scanner = scanner;
        init();
    }

    @Override
    public void start() {
        System.out.println("Tic Tac Toe");

        while (!hasWinner() && !board.isFull()) {
            System.out.println("Spieler " + currentPlayer.getMarker() + " ist am Zug.");

            int x = readCoordinate("Zeile eingeben (0-2): ");
            int y = readCoordinate("Spalte eingeben (0-2): ");

            if (!isValidCoordinate(x, y)) {
                System.out.println("Ungueltige Eingabe. Bitte Werte zwischen 0 und 2 eingeben.");
                continue;
            }

            if (!board.isCellEmpty(x, y)) {
                System.out.println("Dieses Feld ist bereits belegt.");
                continue;
            }

            char marker = currentPlayer.getMarker();
            board.place(x, y, marker);
            moves[x][y] = marker;
            board.print();

            if (hasWinner()) {
                System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
                return;
            }

            switchCurrentPlayer();
        }

        System.out.println("Unentschieden!");
    }

    private void init() {
        board.clear();
        clearMoves();
        board.print();
        if (currentPlayer == null) {
            setCurrentPlayer(player1);
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void setCurrentPlayer(PlayerInterface p) {
        currentPlayer = p;
    }

    private int readCoordinate(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Bitte eine ganze Zahl eingeben.");
            scanner.next();
            System.out.print(message);
        }
        return scanner.nextInt();
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }

    private void clearMoves() {
        for (int x = 0; x < moves.length; x++) {
            for (int y = 0; y < moves[x].length; y++) {
                moves[x][y] = ' ';
            }
        }
    }

    private boolean hasWinner() {
        // Check all rows and columns.
        // A player wins if all three fields in one row or one column contain the same non-empty marker.
        for (int i = 0; i < 3; i++) {
            // Check row i: [i][0], [i][1], [i][2]
            if (moves[i][0] != ' ' && moves[i][0] == moves[i][1] && moves[i][1] == moves[i][2]) {
                return true;
            }

            // Check column i: [0][i], [1][i], [2][i]
            if (moves[0][i] != ' ' && moves[0][i] == moves[1][i] && moves[1][i] == moves[2][i]) {
                return true;
            }
        }

        // Check the main diagonal from top-left to bottom-right:
        // [0][0], [1][1], [2][2]
        if (moves[0][0] != ' ' && moves[0][0] == moves[1][1] && moves[1][1] == moves[2][2]) {
            return true;
        }

        // Check the second diagonal from top-right to bottom-left:
        // [0][2], [1][1], [2][0]
        return moves[0][2] != ' ' && moves[0][2] == moves[1][1] && moves[1][1] == moves[2][0];
    }
}
