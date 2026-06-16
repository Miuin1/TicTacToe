package player;

import main_game_package.PlayerInterface;

public class Player implements PlayerInterface {

    private char marker;

    public Player(char marker) {
        this.marker = marker;
    }

    @Override
    public char getMarker() {
        return marker;
    }
}
