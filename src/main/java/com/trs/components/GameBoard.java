package com.trs.components;



public class GameBoard implements Board{
	
	int rows;
    int columns;

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public boolean isValidPosition(Position position) {
        return !(
                position.getX() > this.columns || position.getX() < 0 ||
                        position.getY() > this.rows || position.getY() < 0
        );
    }

}
