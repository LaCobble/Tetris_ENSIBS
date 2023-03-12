package com.example.tetris.Interfaces;
import com.example.tetris.Point;
import javafx.scene.paint.Color;

public interface TetrominoInterface {

    Point[] canMoveRight();

    Point[] canMoveLeft();

    Point[] canMoveDown();

    Point[] canRotateClockwise();

    boolean moveRight();

    boolean moveLeft();

    boolean moveDown();

    boolean rotateClockwise();

    Color getColor();
}
