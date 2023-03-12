package com.example.tetris;

import com.example.tetris.Interfaces.CellInterface;

import javafx.scene.paint.Color;

/**
 * The `Cell` class represents a single cell of the Tetris game's grid.
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 */
public class Cell implements CellInterface {

    /**
     * The color of the cell.
     */
    private final Color color;

    /**
     * The tetromino object that the cell belongs to.
     */
    private final Tetromino parentTetromino;

    /**
     * Constructs a new `Cell` object with the specified Tetromino object and coordinates.
     *
     * @param tetromino The Tetromino object that the cell belongs to.
     */
    public Cell(Tetromino tetromino) {
        this.color = tetromino.getColor();
        this.parentTetromino = tetromino;
    }

    /**
     * Returns the color of the cell.
     *
     * @return The `Color` object representing the color of the cell.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Returns the Tetromino object that the cell belongs to.
     *
     * @return The `Tetromino` object that the cell belongs to.
     */
    public Tetromino getParentTetromino() {
        return parentTetromino;
    }
}
