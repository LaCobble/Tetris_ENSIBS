package com.tetris.Interfaces;


import com.tetris.Cell;
import com.tetris.Tetromino;

public interface TetrisBoardInterface {


    void updateGrid(Tetromino oldTetromino, Tetromino newTetromino);

    int checkLineCompletion(Cell[][] grid);

    void clearLine(int y);


    int generationBalancedRandomNumbers();

    Tetromino getActualTetromino();

    Tetromino getNextTetromino();

    void setTetrominoOrder();
}

