package board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void constructorCreatesEmpty3x3Board() {
        Board board = new Board();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                assertTrue(board.isCellEmpty(x, y));
            }
        }
    }

    @Test
    void boardHasNoFieldsOutside3x3() {
        Board board = new Board();

        assertFalse(board.isCellEmpty(3, 0));
        assertFalse(board.isCellEmpty(0, 3));
        assertFalse(board.isCellEmpty(-1, 0));
        assertFalse(board.isCellEmpty(0, -1));
    }


    @Test
    void clearRemovesAllMarkers() {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.place(2, 2, 'X');

        board.clear();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                assertTrue(board.isCellEmpty(x, y));
            }
        }
    }

}