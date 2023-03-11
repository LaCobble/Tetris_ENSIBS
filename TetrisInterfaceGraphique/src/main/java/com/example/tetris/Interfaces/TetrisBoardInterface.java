package com.example.tetris.Interfaces;

import com.example.tetris.Cell;
import com.example.tetris.Tetromino;



public interface TetrisBoardInterface {


    void updateGrid(Tetromino oldTetromino, Tetromino newTetromino);

    int checkLineCompletion(Cell[][] grid);

    void clearLine(int y);


    int generationBalancedRandomNumbers();

    Tetromino getActualTetromino();

    Tetromino getNextTetromino();

    void setTetrominoOrder();
}

