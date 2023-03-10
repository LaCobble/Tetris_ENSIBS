package Interfaces;

import Enum.TetrominoType;

import java.awt.*;

public interface TetrominoInterface {

    PointInterface[] canMoveLeft();

    PointInterface[] canMoveRight();

    PointInterface[] canMoveDown();

    PointInterface[] canRotateClockwise();

    PointInterface[] canRotateCounterClockwise();

    void moveLeft();

    void moveRight();

    void moveDown();

    void rotateClockwise();

    void rotateCounterClockwise();

    TetrominoType getTetrominoType();

    int getRotation();
    Color getColor();
}
