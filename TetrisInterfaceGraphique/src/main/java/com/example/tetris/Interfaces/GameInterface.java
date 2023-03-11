package com.example.tetris.Interfaces;

import com.example.tetris.TetrisBoard;
import com.example.tetris.Tetromino;

public interface GameInterface {
    void start();
    void end();
    void updateHighScore();
    void displayHighScore();
    Integer getBestScore();
    void saveBestScore();
    void pause();
    void resume();
    void displayCredits();
    void setScore();
    void getScore();
    TetrisBoard getTetrisBoard();
    Tetromino getCurrentTetromino();
}
