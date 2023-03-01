package Interfaces;

import Enum.TetrominoType;

public interface TetrominoInterface {

    boolean canMoveLeft();

    boolean canMoveRight();

    boolean canRotate();

    boolean canMoveDown();

    void moveLeft();

    void moveRight();

    void moveDown();

    void rotate();

    void fall();

    TetrominoType getTetrominoType();

    int getRotation();

    void rotateClockwise();

    void rotateCounterClockwise();
}
