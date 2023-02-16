package Interfaces;

public interface GameInterface {
    void start();
    void end();
    void updateHighScore();
    void displayHighScore();
    Integer getBestScore();
    void saveBestScore();
    void pause();
    void resume();
}
