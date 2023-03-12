package com.tetris.Interfaces;

import com.tetris.Enum.TetrominoType;
import com.tetris.Point;
import javafx.scene.paint.Color;

public interface TetrominoInterface {

    Point[] canMoveLeft();

    Point[] canMoveRight();

    Point[] canMoveDown();

    Point[] canRotateClockwise();

    Point[] canRotateCounterClockwise();

    boolean moveLeft();

    boolean moveRight();

    boolean moveDown();

    boolean rotateClockwise();

    boolean rotateCounterClockwise();

    TetrominoType getTetrominoType();

    int getRotation();
    Color getColor();
}
