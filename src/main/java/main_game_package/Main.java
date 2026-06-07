package main_game_package;

import game_master.TicTacToe;

public class Main {
    static void main() {

        try {

            TicTacToe t = new TicTacToe();
            t.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
