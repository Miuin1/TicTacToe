package main_game_package;

import game_master.TicTacToe;

public class Main {
    static void main() {

        try {

            TicTacToe t = new TicT acToe();
            t.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
