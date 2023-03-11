package com.example.tetris.Interfaces;

import com.example.tetris.Enum.TetrominoType;
import com.example.tetris.Point;
import javafx.scene.paint.Color;

public interface TetrominoInterface {

    Point[] canMoveLeft();

    Point[] canMoveRight();

    Point[] canMoveDown();

    Point[] canRotateClockwise();

    Point[] canRotateCounterClockwise();

    void moveLeft();

    void moveRight();

    void moveDown();

    void rotateClockwise();

    void rotateCounterClockwise();

    TetrominoType getTetrominoType();

    int getRotation();
    Color getColor();
}
