package com.example.tetris.Interfaces;

public interface GridInterface {
    public CellInterface[][] Grid(int[] dimension);
    Boolean isCellOccupied( int x,int y);
    int getDimensionX();
    int getDimensionY();

    int getX();
    int getY();
}
