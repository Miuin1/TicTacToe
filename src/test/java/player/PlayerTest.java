package player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void constructorStoresMarkerX() {
        Player player = new Player('X');

        assertEquals('X', player.getMarker());
    }

    @Test
    void constructorStoresMarkerO() {
        Player player = new Player('O');

        assertEquals('O', player.getMarker());
    }

    @Test
    void getMarkerReturnsStoredMarkerX() {
        Player player = new Player('X');

        char marker = player.getMarker();

        assertEquals('X', marker);
    }

    @Test
    void getMarkerReturnsStoredMarkerO() {
        Player player = new Player('O');

        char marker = player.getMarker();

        assertEquals('O', marker);
    }

    @Test
    void getMarkerDoesNotChangePlayerState() {
        Player player = new Player('X');

        char firstCall = player.getMarker();
        char secondCall = player.getMarker();

        assertEquals(firstCall, secondCall);
        assertEquals('X', secondCall);
    }
}
