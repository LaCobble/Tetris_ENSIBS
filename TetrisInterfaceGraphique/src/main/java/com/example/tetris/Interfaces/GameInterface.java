package com.example.tetris.Interfaces;

import com.example.tetris.TetrisBoard;
import com.example.tetris.Tetromino;

public interface GameInterface {

    void start();

    void end();

    void pause();

    void resume();

    Boolean getIsRunning();

    TetrisBoard getTetrisBoard();

    Tetromino getCurrentTetromino();

    void setCurrentTetromino(Tetromino t);
}
