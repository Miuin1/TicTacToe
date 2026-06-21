package board;

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
        if (!isValidCoordinate(x, y)) {
            return false;
        }

        return cells[x][y] == EMPTY;
    }

    @Override
    public void place(int x, int y, char marker){
        if (!isValidCoordinate(x, y)) {
            System.out.println("Not in field!");
            return;
        }

        if (!isCellEmpty(x, y)) {
            System.out.println("Field is already occupied!");
            return;
        }

        cells[x][y] = marker;
    }

    private boolean isValidCoordinate(int x, int y){
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    @Override
    public boolean isFull(){
        for(int x=0; x < SIZE; x++){
            for(int y=0; y < SIZE; y++){
                if(cells[x][y] == EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void print(){
        System.out.println("-------");
        for(int x=0; x < SIZE; x++){
            for(int y=0; y < SIZE; y++){
                System.out.print("|" + cells[x][y]);
            }
            System.out.println("|");
        }
        System.out.println("-------");
    }

}
