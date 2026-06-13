package game_master;

import main_game_package.BoardInterface;


public class Board implements BoardInterface{

    private static final int SIZE = 3;

    private static final char EMPTY = ' ';

    private char[][] cells;

    public Board(){
        cells = new char[SIZE][SIZE];
        clear();

    }

    @Override
    public void clear(){
        for(int x=0; x < SIZE; x++){
            for(int y=0; y < SIZE; y++){
                cells[x][y] = EMPTY;
            }
        }
    }

    @Override
    public boolean isCellEmpty(int x, int y){
        return cells[x][y] == EMPTY;
    }

    @Override
    public void place(int x, int y, char marker){

    }

    @Override
    public boolean isFull(){
        return cells[SIZE][SIZE] == EMPTY;
    }

    @Override
    public void print(){

    }



}
