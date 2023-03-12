package com.example.tetris;

import com.example.tetris.Enum.TetrominoType;
import com.example.tetris.Interfaces.TetrominoInterface;

import javafx.scene.paint.Color;

/**
 * Tetromino class is used to create a Tetromino object, which is a piece of the game. It is used to create the 7 different pieces of the game.
 *
 * <p>
 * Tetromino attributes:
 * <ul>
 *     <li> type : the type of the Tetromino (Z, L, O, S, I, J, T) </li>
 *     <li> positions : the positions of the Tetromino on the grid </li>
 *     <li> color : the color of the Tetromino </li>
 * </ul>
 * </p>
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 */
public class Tetromino implements TetrominoInterface {

    /**
     * Type of the Tetromino (Z, L, O, S, I, J, T)
     */    protected TetrominoType type;

    /**
     * Positions of the Tetromino on the grid
     */    protected Point[] positions = new Point[4];

    /**
     * Color of the Tetromino
     */    protected Color color;

    /**
     * Constructs a Tetromino object.
     *
     * @param type the type of the Tetromino (Z, L, O, S, I, J, T)
     */
    public Tetromino(TetrominoType type) {
        this.type = type;
        switch (type) {
            case Z -> {
                color = Color.RED;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
            }
            case L -> {
                color = Color.ORANGE;
                positions[0] = new Point(3, 1);
                positions[1] = new Point(4, 1);
                positions[2] = new Point(5, 1);
                positions[3] = new Point(5, 0);
            }
            case O -> {
                color = Color.YELLOW;
                positions[0] = new Point(4, 0);
                positions[1] = new Point(5, 0);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
            }
            case S -> {
                color = Color.GREEN;
                positions[0] = new Point(3, 1);
                positions[1] = new Point(4, 1);
                positions[2] = new Point(4, 0);
                positions[3] = new Point(5, 0);
            }
            case I -> {
                color = Color.CYAN;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(5, 0);
                positions[3] = new Point(6, 0);
            }
            case J -> {
                color = Color.BLUE;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(3, 1);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
            }
            case T -> {
                color = Color.MAGENTA;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(5, 0);
                positions[3] = new Point(4, 1);
            }
        }
    }

    /**
     * Constructs a new `Tetromino` object as a copy of the specified `Tetromino` object.
     *
     * @param original The `Tetromino` object to copy.
     */
    public Tetromino(Tetromino original) {
        this.type = original.type;
        this.positions = new Point[4];
        for (int i = 0; i < original.positions.length; i++) {
            this.positions[i] = new Point(original.positions[i].getX(), original.positions[i].getY());
        }
        this.color = original.color;
    }

    /**
     * Checks if the Tetromino can move left.
     * Returns the new positions of the Tetromino if it can move left, or null if it cannot.
     *
     * @return an array of Point objects representing the new positions of the Tetromino if it can move left, or null if it cannot.
     */
    @Override
    public Point[] canMoveLeft() {
        Point[] newPositions = new Point[4];
        for (int i = 0; i < positions.length; i++) {
            Point p = positions[i];
            int x = p.getX() - 1;
            int y = p.getY();
            if (x < 0 ||
                    (TetrisBoard.getInstance().getBoard().getCell(x, y) != null && TetrisBoard.getInstance().getBoard().getCell(x, y).getParentTetromino() != this)) {
                return null;
            }
            newPositions[i] = new Point(x, y);
        }
        return newPositions;
    }

    /**
     * Checks if the Tetromino can move right.
     * Returns the new positions of the Tetromino if it can move right, or null if it cannot.
     *
     * @return an array of Point objects representing the new positions of the Tetromino if it can move right, or null if it cannot.
     */
    @Override
    public Point[] canMoveRight() {
        Point[] newPos = new Point[4];
        for (int i = 0; i < positions.length; i++) {
            Point p = positions[i];
            int x = p.getX() + 1;
            int y = p.getY();
            if (x >= Board.colDimension ||
                    (TetrisBoard.getInstance().getBoard().getCell(x, y) != null &&
                            TetrisBoard.getInstance().getBoard().getCell(x, y).getParentTetromino() != this)) {
                return null;
            }
            newPos[i] = new Point(x, y);
        }
        return newPos;
    }

    /**
     * Checks if the Tetromino can move down.
     * Returns the new positions of the Tetromino if it can move down, or null if it cannot.
     *
     * @return an array of Point objects representing the new positions of the Tetromino if it can move down, or null if it cannot.
     */
    @Override
    public Point[] canMoveDown() {
        Point[] newPos = new Point[4];
        for (int i = 0; i < positions.length; i++) {
            Point p = positions[i];
            int x = p.getX();
            int y = p.getY() + 1;
            if (y >= Board.lineDimension  ||
                    ((TetrisBoard.getInstance().getBoard().getCell(x, y) != null &&
                            TetrisBoard.getInstance().getBoard().getCell(x, y).getParentTetromino() != this))) {
                return null;
            }
            newPos[i] = new Point(x, y);
        }
        return newPos;
    }

    /**
     * Checks if the Tetromino can rotate clockwise.
     * Returns the new positions of the Tetromino if it can move rotate clockwise, or null if it cannot.
     *
     * @return an array of Point objects representing the new positions of the Tetromino if it can rotate clockwise, or null if it cannot.
     */
    @Override
    public Point[] canRotateClockwise() {
        Point center = positions[1];
        Point[] newPositions = new Point[4];
        for (int i = 0; i < positions.length; i++) {
            Point p = positions[i];
            if (p == center) {
                newPositions[i] = center;
                continue;
            }
            int newX = center.getX() - center.getY() + p.getY();
            int newY = center.getY() + center.getX() - p.getX();
            if (newX < 0 || newX >= Board.colDimension ||
                    newY < 0 || newY >= Board.lineDimension ||
                    (TetrisBoard.getInstance().getBoard().getCell(newX, newY) != null &&
                            TetrisBoard.getInstance().getBoard().getCell(newX, newY).getParentTetromino() != this)) {
                return null;
            }
            newPositions[i] = new Point(newX, newY);
        }
        return newPositions;
    }

    /**
     * Attempts to move the tetromino one cell to the left.
     *
     * @return true if the tetromino was moved successfully, false otherwise.
     */
    @Override
    public boolean moveLeft() {
        Point[] newPos = canMoveLeft();
        if (newPos != null) {
            positions = newPos;
            return true;
        }
        return false;
    }

    /**
     * Attempts to move the tetromino one cell to the right.
     *
     * @return true if the tetromino was moved successfully, false otherwise.
     */
    @Override
    public boolean moveRight() {
        Point[] newPos = canMoveRight();
        if (newPos != null) {
            positions = newPos;
            return true;
        }
        return false;
    }

    /**
     * Attempts to move the tetromino one cell downwards.
     *
     * @return true if the tetromino was moved successfully, false otherwise.
     */
    @Override
    public boolean moveDown() {
        Point[] newPos = canMoveDown();
        if (newPos != null) {
            positions = newPos;
            return true;
        }
        return false;
    }

    /**
     * Attempts to rotate the tetromino.
     *
     * @return true if the tetromino was rotated successfully, false otherwise.
     */
    @Override
    public boolean rotateClockwise() {
        Point[] newPos = canRotateClockwise();
        if (newPos != null) {
            positions = newPos;
            return true;
        }
        return false;
    }

    /**
     * Returns the color of this tetromino.
     *
     * @return the color of this tetromino
     */
    public Color getColor(){
        return color;
    }

    /**
     * Returns an array of Point objects representing the current positions of the tetromino blocks.
     *
     * @return an array of Point objects representing the current positions of the tetromino blocks.
     */
    public Point[] getPositions() {
        return positions;
    }
}
