package com.example.tetris.Interfaces;

import com.example.tetris.Tetromino;



public interface TetrisBoardInterface {


    void update();

    void render();

    int[] checkLineCompletion();

    void clearLine(int y);


    int generationBalancedRandomNumbers();

    Tetromino getActualTetromino();

    Tetromino getNextTetromino();

    void setTetrominoOrder();
    void aside();
}

