package main_game_package;

import board.Board;
import game_master.TicTacToe;
import player.Player;

public class Main {
    static void main() {

        try {

            TicTacToe t = new TicTacToe(
                    new Player('X'),
                    new Player('O'),
                    new Board()
            );
            t.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
