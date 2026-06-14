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
        if(cells[x-1][y-1] != EMPTY){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void place(int x, int y, char marker){
        if(x>3 || y>3){
            System.out.println("Not in field!");
            return;
        }
        cells[x-1][y-1] = marker;

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
        System.out.println("▁▁▁▁▁▁");
        for(int x=0; x < SIZE; x++){
            for(int y=0; y < SIZE; y++){
                System.out.print("|");
                System.out.print(cells[x][y]);
                if(x==2){
                    System.out.print("|\n");
                }
            }
        }
        System.out.println("▁▁▁▁▁▁");
    }



}
