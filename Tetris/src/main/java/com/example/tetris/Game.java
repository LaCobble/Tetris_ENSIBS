package com.example.tetris;

import com.example.tetris.Interfaces.GameInterface;

/**
 * Game class represents the game itself. It has a TetrisBoard, a current Tetromino, and methods to start, pause, end and resume the game.
 * It also has getters and setters for its attributes.
 *
 * <p>
 * Game attributes:
 * <ul>
 *      <li> tetrisBoard : the TetrisBoard of the game </li>
 *      <li> currentTetromino : the current Tetromino in the game </li>
 *      <li> isRunning : boolean to see if the game is running </li>
 * </ul>
 * </p>
 * @author Cyberlog - Groupe 2
 * @version 1.0
 */
public class Game implements GameInterface {

    /**
     * The TetrisBoard of the game.
     */
    private final TetrisBoard tetrisBoard;

    /**
     * The current Tetromino in the game.
     */
    private Tetromino currentTetromino;

    /**
     * Boolean to see if the game is running.
     */
    private boolean isRunning;

    /**
     * Constructs a Game object with default values.
     */
    public Game() {
        isRunning = true;
        tetrisBoard = TetrisBoard.getInstance();
    }

    /**
     * This method is used to start the game
     */
    public void start() {
        setCurrentTetromino(tetrisBoard.generateTetromino());
        tetrisBoard.addTetrominoToBoard(currentTetromino);
    }

    /**
     * This method is used to pause the game
     */
    public void pause() {
        isRunning = false;
    }

    /**
     * This method is used to check if the game ended
     */
    public void end() {
        isRunning = false;
        System.out.println("Game Over");
    }

    /**
     * This method is used to restart the game
     *
     */
    public void resume() {
        isRunning = true;
    }

    /**
     * This method is used to see if the game is running
     *
     * @return isRunning
     */
    public Boolean getIsRunning() {
        return isRunning;
    }

    /**
     * This method is the getter of the tetrisBoard
     *
     * @return tetrisBoard
     */
    public TetrisBoard getTetrisBoard() {
        return tetrisBoard;
    }

    /**
     * This method is the getter of the currentTetromino
     *
     * @return currentTetromino
     */
    public Tetromino getCurrentTetromino() {
        return currentTetromino;
    }

    /**
     * This method is the setter of the currentTetromino
     *
     * @param t
     */
    public void setCurrentTetromino(Tetromino t) {
        currentTetromino = t;
    }
}
