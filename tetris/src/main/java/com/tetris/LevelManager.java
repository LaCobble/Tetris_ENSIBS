package com.tetris;

/**
 * LevelManager.java
 * This class is used to manage the level of the game.
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 */
public class LevelManager {

    // the instance of the class
    // the speed of the game
    private static LevelManager instance = null;

    // the score of the player
    private int speed;

    // the speed coefficient
    private int score;

    // the score coefficient
    private float speedCoefficient;

    // the instance of the class
    private float scoreCoefficient;

    /**
     * This method is used to create the instance of the class.
     */
    private LevelManager() {
        speed = 1;
        score = 0;
        speedCoefficient = 1;
        scoreCoefficient = 1;
    }

    /**
     * This method is used to get the instance of the class.
     * @return the instance of the class
     */
    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager();
        }
        return instance;
    }

    /**
     * This method is used to get the speed of the game.
     * @return the speed of the game
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * This method is used to set the speed of the game.
     * @param speed the speed of the game
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * This method is used to get the score of the player.
     * @return the score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * This method is used to set the score of the player.
     * @param score the score of the player
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * This method is used to get the speed coefficient.
     * @return the speed coefficient
     */
    public float getSpeedCoefficient() {
        return speedCoefficient;
    }

    /**
     * This method is used to set the speed coefficient.
     * @param speedCoefficient the speed coefficient
     */
    public void setSpeedCoefficient(int speedCoefficient) {
        this.speedCoefficient = speedCoefficient;
    }

    /**
     * This method is used to get the score coefficient.
     * @return the score coefficient
     */
    public float getScoreCoefficient() {
        return scoreCoefficient;
    }

    /**
     * This method is used to set the score coefficient.
     * @param scoreCoefficient the score coefficient
     */
    public void setScoreCoefficient(int scoreCoefficient) {
        this.scoreCoefficient = scoreCoefficient;
    }

    /**
     * This method is used to reset the level.
     */
    public void reset() {
        speed = 1;
        score = 0;
        speedCoefficient = 1;
        scoreCoefficient = 1;
    }

    /**
     * This method is used to increase the speed of the game : easy level.
     */
    public void easyLevel() {
        speedCoefficient = 1.1F;
        scoreCoefficient = 1.1F;
    }

    /**
     * This method is used to increase the speed of the game : normal level.
     */
    public void normalLevel() {
        speedCoefficient = 1.3F;
        scoreCoefficient = 1.3F;
    }

    /**
     * This method is used to increase the speed of the game : hard level.
     */
    public void hardLevel() {
        speedCoefficient = 1.5F;
        scoreCoefficient = 1.5F;
    }


}