package com.example.tetris.Interfaces;

import com.example.tetris.Tetromino;
import javafx.scene.paint.Color;

public interface CellInterface {
    Color getColor();

    Tetromino getParentTetromino();
}
