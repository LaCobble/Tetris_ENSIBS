package com.example.tetris;

import java.util.*;
import java.io.*;

public class Game {
    private HighScoreManager manager;
    private TetrisBoard tetrisBoard;
    private Tetromino currentTetromino;
    private Tetromino nextTetromino;
    private int score;
    private int highScore;
    private boolean isRunning;
    private LevelManager instance = LevelManager.getInstance();

    public Game() {
        isRunning = true;
        tetrisBoard = TetrisBoard.getInstance();
    }

    /**
     * This method is used to start the game
     */
    public void startGame() {
        System.out.println("Game started.");

        // Create first tetromino
        setCurrentTetromino();
        // Add tetromino to board
        tetrisBoard.addTetrominoToBoard(currentTetromino);

        /*
        // While game is not finished
        while (isRunning) {
            // If current tetromino cannot go down
            if (!currentTetromino.moveDown()) {
                // Create new tetromino
                currentTetromino = tetrisBoard.getActualTetromino();
                // Add tetromino to board
                tetrisBoard.addTetrominoToBoard(currentTetromino);
            }
        }
         */

    }

    /**
     * This method is used to pause the game
     */
    public void pause() {
        // PreCondition : The game is running
        assert(isRunning);
        instance.setSpeed(0);
        isRunning = false;
        // Post-condition: The game is no longer running
        assert(!isRunning);
    }

    /**
     * This method is used to check if the game ended, and displays the score
     */
    public void end(Game game) {
        // Precondition: The game is running
        assert(isRunning);
        Tetromino currentTetromino = game.tetrisBoard.getActualTetromino();
        if ((currentTetromino.canMoveDown() == null) && (currentTetromino.canMoveDown() == null) && (currentTetromino.canMoveDown() == null)) {
            isRunning = false;
            // Display final score
            System.out.println("Final Score: " + score);
            // Precondition: The game is no longer running
            assert (!isRunning);
        }
    }

    /**
     * This method is used to update the highest score
     */
    public void updateHighScore() {
        if (score > highScore) {
            highScore = score;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name for the high score list:");
            String name = scanner.nextLine().trim();
            scanner.close();
            try {
                List<String> highScores = HighScoreManager.readScores();
                highScores.add(name + "," + highScore);
                highScores.sort((s1, s2) -> Integer.compare(Integer.parseInt(s2.split(",")[1]), Integer.parseInt(s1.split(",")[1])));
                highScore = Integer.parseInt(highScores.get(0).split(",")[1]);
                HighScoreManager.writeScore(name, highScore);
            } catch (IOException e) {
                System.err.println("Error reading/writing high score: " + e.getMessage());
            }
        }
    }

    /**
     * This method is used to display the highscore
     */
    public void displayHighScore() {
        System.out.println("High Score: " + highScore);
    }


    /**
     * This method is used to restart the game
     */
    public void resume(){
        // Precondition: The game is not running
        assert(!isRunning);
        isRunning = true;
        instance.setSpeed(1);
        // Post-condition: The game is running
        assert(isRunning);
    }

    /**
     * This method is used to display the credits
     */
    public void displayCredits(){
        System.out.println("This game was created by this awesome squad:");
        System.out.println("Maucourt Pierre-Yves - Latour Morgan - Saudemont Thomas - Ben Nasrallah Ahmed");
    }

    /**
     * This method is used to set a score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * This method is used to get a score
     */
    public int getScore() {
        return score;
    }

    /**
     * This method is used to see if the game is running
     */
    public Boolean getisRunning() {
        return isRunning;
    }

    /**
     * This method is used to change the state of the game
     */
    public void setisRunning(Boolean bool){
        this.isRunning = bool;
    }

    public TetrisBoard getTetrisBoard() {
        return tetrisBoard;
    }

    public Tetromino getCurrentTetromino() {
        return currentTetromino;
    }
    public void setCurrentTetromino(){
        currentTetromino = tetrisBoard.getActualTetromino();
    }
    public void setNextTetromino(){
        nextTetromino = tetrisBoard.getNextTetromino();
    }
    public void swapTetromino(){
        currentTetromino = nextTetromino;
        setNextTetromino();
    }
}
