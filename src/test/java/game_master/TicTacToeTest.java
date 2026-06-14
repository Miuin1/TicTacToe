package game_master;

import main_game_package.BoardInterface;
import main_game_package.PlayerInterface;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
class TicTacToeTest {

    @Test
    void playerXWinsWithFirstRow() {
        PlayerInterface player1 = new TestPlayer('X');
        PlayerInterface player2 = new TestPlayer('O');
        TestBoard board = new TestBoard();

        Scanner scanner = new Scanner("""
                0
                0
                1
                0
                0
                1
                1
                1
                0
                2
                """);

        TicTacToe game = new TicTacToe(player1, player2, board, scanner);

        game.start();

        assertEquals('X', board.cells[0][0]);
        assertEquals('X', board.cells[0][1]);
        assertEquals('X', board.cells[0][2]);
    }

    @Test
    void playerXWinsWithMainDiagonal() {
        PlayerInterface player1 = new TestPlayer('X');
        PlayerInterface player2 = new TestPlayer('O');
        TestBoard board = new TestBoard();

        Scanner scanner = new Scanner("""
                0
                0
                0
                1
                1
                1
                0
                2
                2
                2
                """);

        TicTacToe game = new TicTacToe(player1, player2, board, scanner);

        game.start();

        assertEquals('X', board.cells[0][0]);
        assertEquals('X', board.cells[1][1]);
        assertEquals('X', board.cells[2][2]);
    }

    @Test
    void gameEndsWithDrawWhenBoardIsFull() {
        PlayerInterface player1 = new TestPlayer('X');
        PlayerInterface player2 = new TestPlayer('O');
        TestBoard board = new TestBoard();

        Scanner scanner = new Scanner("""
                0
                0
                0
                1
                0
                2
                1
                0
                1
                2
                1
                1
                2
                0
                2
                2
                2
                1
                """);

        TicTacToe game = new TicTacToe(player1, player2, board, scanner);

        game.start();

        assertTrue(board.isFull());
    }

    @Test
    void occupiedCellIsNotOverwritten() {
        PlayerInterface player1 = new TestPlayer('X');
        PlayerInterface player2 = new TestPlayer('O');
        TestBoard board = new TestBoard();

        Scanner scanner = new Scanner("""
                0
                0
                0
                0
                1
                0
                0
                1
                1
                1
                0
                2
                """);

        TicTacToe game = new TicTacToe(player1, player2, board, scanner);

        game.start();

        assertEquals('X', board.cells[0][0]);
        assertEquals('O', board.cells[1][0]);
    }

    @Test
    void playerOWinsWithFirstColumn() {
        PlayerInterface player1 = new TestPlayer('X');
        PlayerInterface player2 = new TestPlayer('O');
        TestBoard board = new TestBoard();

        Scanner scanner = new Scanner("""
                0
                1
                0
                0
                0
                2
                1
                0
                1
                1
                2
                0
                """);

        TicTacToe game = new TicTacToe(player1, player2, board, scanner);

        game.start();

        assertEquals('O', board.cells[0][0]);
        assertEquals('O', board.cells[1][0]);
        assertEquals('O', board.cells[2][0]);
    }

    private static class TestPlayer implements PlayerInterface {
        private final char marker;

        TestPlayer(char marker) {
            this.marker = marker;
        }

        @Override
        public char getMarker() {
            return marker;
        }
    }

    private static class TestBoard implements BoardInterface {
        private final char[][] cells = new char[3][3];

        TestBoard() {
            clear();
        }

        @Override
        public boolean isCellEmpty(int x, int y) {
            return cells[x][y] == ' ';
        }

        @Override
        public void place(int x, int y, char marker) {
            if (isCellEmpty(x, y)) {
                cells[x][y] = marker;
            }
        }

        @Override
        public boolean isFull() {
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    if (cells[x][y] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public void clear() {
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    cells[x][y] = ' ';
                }
            }
        }

        @Override
        public void print() {
            // Für Tests nicht notwendig.
        }
    }
}