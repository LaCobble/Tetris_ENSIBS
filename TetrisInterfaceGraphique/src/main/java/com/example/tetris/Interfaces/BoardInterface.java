package com.example.tetris.Interfaces;
import com.example.tetris.Cell;
import com.example.tetris.Tetromino;

public interface BoardInterface {

    void addCell(Tetromino tetromino, int x, int y);

    void deleteCell(int x,int y);

    Cell getCell(int x,int y);

    Cell[][] getGrid();

    void moveCell(int x, int y, int newX,int newY);
}
