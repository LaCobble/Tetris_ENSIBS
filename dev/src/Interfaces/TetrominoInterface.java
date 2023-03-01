package Interfaces;

import Enum.TetrominoType;

public interface TetrominoInterface {

    boolean canMoveLeft();

    boolean canMoveRight();

    boolean canRotate();

    boolean canFall();

    void moveLeft();

    void moveRight();

    void moveDown();

    void rotate();

    void fall();

    void getX();

    void getY();

    TetrominoType getTetrominoType();

    int getRotation();

    void rotateClockwise();

    void rotateCounterClockwise();
}
