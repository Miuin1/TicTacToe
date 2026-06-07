package game_master;

import main_game_package.TicTacToeInterface;

public class TicTacToe implements TicTacToeInterface {

    public TicTacToe() {}

    @Override
    public void start() {
        System.out.println( "Tic Tac Toe");
    }
}
