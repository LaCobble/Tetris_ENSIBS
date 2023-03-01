package Interfaces;

import Enum.TetrominoType;

public interface TetrominoInterface {

    boolean canMoveLeft();

    boolean canMoveRight();

    boolean canMoveDown();

    boolean canRotateClockwise();

    boolean canRotateCounterClockwise();

    void moveLeft();

    void moveRight();

    void moveDown();

    void rotateClockwise();

    void rotateCounterClockwise();

    TetrominoType getTetrominoType();

    int getRotation();
}
