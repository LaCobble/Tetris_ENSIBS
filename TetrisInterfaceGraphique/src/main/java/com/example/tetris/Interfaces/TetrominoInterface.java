package com.example.tetris.Interfaces;
import com.example.tetris.Point;
import javafx.scene.paint.Color;

public interface TetrominoInterface {

    Point[] canMoveLeft();

    Point[] canMoveRight();

    Point[] canMoveDown();

    Point[] canRotateClockwise();

    boolean moveLeft();

    boolean moveRight();

    boolean moveDown();

    boolean rotateClockwise();

    Color getColor();
}
