import Enum.TetrominoType;
import Interfaces.TetrominoInterface;

import javax.swing.text.Position;
import java.awt.*;

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
                color = Color.red;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
            }
            case L -> {
                color = Color.orange;
                positions[0] = new Point(3, 1);
                positions[1] = new Point(4, 1);
                positions[2] = new Point(5, 1);
                positions[3] = new Point(5, 0);
            }
            case O -> {
                color = Color.yellow;
                positions[0] = new Point(4, 0);
                positions[1] = new Point(5, 0);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
            }
            case S -> {
                color = Color.green;
                positions[0] = new Point(3, 1);
                positions[1] = new Point(4, 1);
                positions[2] = new Point(4, 0);
                positions[3] = new Point(5, 0);
            }
            case I -> {
                color = Color.cyan;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(5, 0);
                positions[3] = new Point(6, 0);
            }
            case J -> {
                color = Color.blue;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(3, 1);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
            }
            case T -> {
                color = Color.magenta;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(5, 0);
                positions[3] = new Point(4, 1);
            }
        }
    }

    // Methods of the class Tetromino :

    /**
     * This method is used to get the color of the Tetromino.
     * @return the color of the Tetromino
     */
    @Override
    public boolean canMoveLeft() {
        for (Point p : positions) {
            if (p.getX() == 0) {
                System.out.println("Tetromino cannot move left.");
                return false;
            }
        }
        return true;
    }

    /**
     * This method is a test to see if the Tetromino can move right.
     * @return true if the Tetromino can move right, false otherwise
     */
    @Override
    public boolean canMoveRight() {
        for (Point p : positions) {
            if (p.getX() == 9) {
                System.out.println("Tetromino cannot move right.");
                return false;
            }
        }
        return true;
    }

    /**
     * This method is a test to see if the Tetromino can move down.
     * @return true if the Tetromino can move down, false otherwise
     */
    @Override
    public boolean canMoveDown() {
        for (Point p : positions) {
            if (p.getY() == 9) {
                System.out.println("Tetromino cannot move down.");
                return false;
            }
        }
        return true;
    }

    /**
     * This method is a test to see if the Tetromino can rotate clockwise.
     * @return true if the Tetromino can rotate clockwise, false otherwise
     */
    @Override
    public boolean canRotateClockwise() {
        return false;
    }

    /**
     * This method is a test to see if the Tetromino can rotate counter clockwise.
     * @return true if the Tetromino can rotate counter clockwise, false otherwise
     */
    @Override
    public boolean canRotateCounterClockwise() {
        return false;
    }

    /**
     * This method is used to move the Tetromino to the left.
     */
    @Override
    public void moveLeft() {
        if (canMoveLeft()) {
            for (Point p : positions) {
                p.setX(p.getX() - 1);
            }
        }
    }

    /**
     * This method is used to move the Tetromino to the right.
     */
    @Override
    public void moveRight() {
        if (canMoveRight()) {
            for (Point p : positions) {
                p.setX(p.getX() + 1);
            }
        }
    }

    /**
     * This method is used to move the Tetromino down.
     */
    @Override
    public void moveDown() {
        if (canMoveDown()) {
            for (Point p : positions) {
                p.setY(p.getY() - 1);
            }
        }
    }

    /**
     * This method is used to rotate the Tetromino clockwise.
     */
    @Override
    public void rotateClockwise() {

    }

    /**
     * This method is used to rotate the Tetromino counter clockwise.
     */
    @Override
    public void rotateCounterClockwise() {

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
     * @return the color of the Tetromino
     */
    public Color getColor(){
        return color;
    }


    @Override
    public int getRotation() {
        return rotation;
    }

    public Point[] getPositions() {
        return positions;
    }
}
