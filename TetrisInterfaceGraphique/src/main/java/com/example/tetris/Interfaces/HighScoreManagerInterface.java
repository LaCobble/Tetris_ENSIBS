package Interfaces;

import java.util.List;

public interface HighScoreManagerInterface {
    void addScore(Integer score);
    List<Integer> getHighScore();
    void clearHighScore();
}
