package main_game_package;

public interface BoardInterface {

    boolean isCellEmpty(int x, int y);

    void place(int x, int y, char marker);

    boolean isFull();

    void clear();

    void print();
}
