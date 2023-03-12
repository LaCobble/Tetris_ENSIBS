package com.tetris;

import com.tetris.Enum.TetrominoType;
import com.tetris.Interfaces.TetrominoInterface;
import javafx.scene.paint.Color;

/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used to create a Tetromino object, which is a piece of the game. It is used to create the 7 different pieces of the game.
 *
 */
public class Tetromino implements TetrominoInterface {

    // Attributes of the class Tetromino :
    // - type : the type of the Tetromino (Z, L, O, S, I, J, T)
    protected TetrominoType type;

    // - positions : the positions of the Tetromino on the grid
    protected Point[] positions = new Point[4];

    // - rotation : the rotation of the Tetromino
    protected int rotation = 0;

    // - color : the color of the Tetromino
    protected Color color;

    /**
     * This constructor is used to create a Tetromino object.
     * @param type the type of the Tetromino (Z, L, O, S, I, J, T)
     */
    public Tetromino(TetrominoType type) {
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

     This constructor is used to create a clone of a Tetromino object.

     @param original the original Tetromino object to clone
     */
    public Tetromino(Tetromino original) {
        this.type = original.type;
        this.positions = new Point[4];
        for (int i = 0; i < original.positions.length; i++) {
            this.positions[i] = new Point(original.positions[i].getX(), original.positions[i].getY());
        }
        this.rotation = original.rotation;
        this.color = original.color;
    }

    /**
     * Checks if the Tetromino can move left.
     * If it can, it returns the new coordinates after moving left.
     * @return the new coordinates if the Tetromino can move left, null otherwise
     */
    @Override
    public Point[] canMoveLeft() {
        Point[] newPositions = new Point[4];

        for (int i = 0; i < positions.length; i++) {
            Point p = positions[i];

            int x = p.getX() - 1;
            int y = p.getY();

            if (x < 0 ||
                    (TetrisBoard.getInstance().getBoard().getCell(x, y) != null &&
                            TetrisBoard.getInstance().getBoard().getCell(x, y).getParentTetromino() != this)) {
                System.out.println("Tetromino cannot move left.");
                return null;
            }

            newPositions[i] = new Point(x, y);
        }

        return newPositions;
    }


    /**
     * Checks if the Tetromino can move right.
     * If it can, it returns the new coordinates after moving right.
     * @return the new coordinates if the Tetromino can move right, null otherwise
     */
    @Override
    public Point[] canMoveRight() {
        Point[] newPos = new Point[4];

        for (int i = 0; i < positions.length; i++) {
            Point p = positions[i];

            int x = p.getX() + 1;
            int y = p.getY();

            if (x >= Board.dimensionX ||
                    (TetrisBoard.getInstance().getBoard().getCell(x, y) != null &&
                            TetrisBoard.getInstance().getBoard().getCell(x, y).getParentTetromino() != this)) {
                System.out.println("Tetromino cannot move right.");
                return null;
            }

            newPos[i] = new Point(x, y);
        }

        return newPos;
    }


    /**
     * Checks if the Tetromino can move down.
     * If it can, it returns the new coordinates after moving down.
     * @return the new coordinates if the Tetromino can move down, null otherwise
     */
    @Override
    public Point[] canMoveDown() {
        //System.out.println("Old x  " + positions[0].getX());
        //System.out.println("Old y  " + positions[0].getY());
        Point[] newPos = new Point[4];
        for (int i = 0; i < positions.length; i++) {
            Point p = positions[i];

            int x = p.getX();
            int y = p.getY() + 1;

            if (y >= Board.dimensionY ||
                    (TetrisBoard.getInstance().getBoard().getCell(x, y) != null &&
                            TetrisBoard.getInstance().getBoard().getCell(x, y).getParentTetromino() != this)) {
                System.out.println("Tetromino cannot move down.");
                return null;
            }

            newPos[i] = new Point(x, y);
        }
        return newPos;
    }


    /**
     * This method checks if the Tetromino can rotate clockwise.
     * If it can, it returns the new coordinates after rotation.
     * @return the new coordinates if the Tetromino can rotate clockwise, null otherwise
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

            if (newX < 0 || newX >= Board.dimensionX ||
                    newY < 0 || newY >= Board.dimensionY ||
                    (TetrisBoard.getInstance().getBoard().getCell(newX, newY) != null &&
                            TetrisBoard.getInstance().getBoard().getCell(newX, newY).getParentTetromino() != this)) {
                System.out.println("Tetromino cannot rotate clockwise.");
                return null;
            }

            newPositions[i] = new Point(newX, newY);
        }

        return newPositions;
    }


    /**
     * This method checks if the Tetromino can rotate counter-clockwise.
     * If it can, it returns the new coordinates after rotation.
     * @return the new coordinates if the Tetromino can rotate counter-clockwise, null otherwise
     */
    @Override
    public Point[] canRotateCounterClockwise() {
        Point center = positions[1];
        Point[] newPos = new Point[4];

        for (int i = 0; i < positions.length; i++) {
            Point p = positions[i];

            if (p == center) {
                newPos[i] = center;
                continue;
            }

            int newX = center.getX() + center.getY() - p.getY();
            int newY = center.getY() - center.getX() + p.getX();

            if (newX < 0 || newX >= Board.dimensionX ||
                    newY < 0 || newY >= Board.dimensionY ||
                    (TetrisBoard.getInstance().getBoard().getCell(newX, newY) != null &&
                            TetrisBoard.getInstance().getBoard().getCell(newX, newY).getParentTetromino() != this)) {
                System.out.println("Tetromino cannot rotate counterclockwise.");
                return null;
            }

            newPos[i] = new Point(newX, newY);
        }

        return newPos;
    }

    /**
     * This method is used to move the Tetromino to the left.
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
     * This method is used to move the Tetromino to the right.
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
     * This method is used to move the Tetromino down.
     */
    @Override
    public boolean moveDown() {
        Point[] newPos = canMoveDown();
        if (newPos != null) {
            positions = newPos;
            //System.out.println("New x  " + positions[0].getX());
            //System.out.println("New y  " + positions[0].getY());
            return true;
        }
        return false;
    }

    /**
     * This method is used to rotate the Tetromino clockwise.
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
     * This method is used to rotate the Tetromino counterclockwise.
     */
    @Override
    public boolean rotateCounterClockwise() {
        Point[] newPos = canRotateCounterClockwise();
        if (newPos != null) {
            positions = newPos;
            return true;
        }
        return false;
    }

    /**
     * This method is used to get the positions of the Tetromino.
     * @return the positions of the Tetromino
     */
    @Override
    public TetrominoType getTetrominoType() {
        return type;
    }

    /**
     * This method is used to get the color of the Tetromino.
     *
     * @return the color of the Tetromino
     */
    public Color getColor(){
        return color;
    }

    /**
     * This method is used to get the rotation of the Tetromino.
     * @return the rotation of the Tetromino
     */
    @Override
    public int getRotation() {
        return rotation;
    }

    /**
     * This method is used to get the positions of the Tetromino.
     * @return the positions of the Tetromino
     */
    public Point[] getPositions() {
        return positions;
    }
}
