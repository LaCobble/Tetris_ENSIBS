package com.example.tetris.Interfaces;

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
}
