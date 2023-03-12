package com.example.tetris;

import com.example.tetris.Interfaces.BoardInterface;

/**
 * The `Board` class represents the grid of the Tetris game.
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 */
public class Board implements BoardInterface {

    /**
     * The grid is a 2D array of cells.
     */
    private final Cell[][] grid;

    /**
     * The number of columns in the grid.
     */
    public static int colDimension = 10;

    /**
     * The number of lines in the grid.
     */
    public static int lineDimension = 20;

    /**
     * Constructs a new `Board` object with the specified dimensions.
     */
    public Board() {
        grid = new Cell[colDimension][lineDimension];
    }

    /**
     * Adds a new cell with the specified Tetromino object to the grid at the given x and y coordinates.
     *
     * @param tetromino The Tetromino object to add to the cell.
     * @param x         The x-coordinate of the cell in the grid.
     * @param y         The y-coordinate of the cell in the grid.
     */
    public void addCell(Tetromino tetromino, int x, int y) {
        assert (colDimension >= x && x >= 0);
        assert (lineDimension >= y && y >= 0);
        grid[x][y] = new Cell(tetromino);
    }

    /**
     * Moves the cell from the specified coordinates to the new coordinates.
     *
     * @param x    The x-coordinate of the cell to move.
     * @param y    The y-coordinate of the cell to move.
     * @param newX The x-coordinate of the new cell.
     * @param newY The y-coordinate of the new cell.
     */
    public void moveCell(int x, int y, int newX, int newY) {
        grid[newX][newY] = grid[x][y];
        deleteCell(x, y);
    }

    /**
     * Deletes the cell at the specified coordinates.
     *
     * @param x The x-coordinate of the cell to delete.
     * @param y The y-coordinate of the cell to delete.
     */
    public void deleteCell(int x, int y) {
        grid[x][y] = null;
    }

    /**
     * Returns the cell at the specified coordinates.
     *
     * @param x The x-coordinate of the cell to get.
     * @param y The y-coordinate of the cell to get.
     * @return The `Cell` object at the specified coordinates.
     */
    public Cell getCell(int x, int y) {
        assert (colDimension >= x && x >= 0);
        assert (lineDimension >= y && y >= 0);
        return grid[x][y];
    }

    /**
     * Returns the grid of the board.
     *
     * @return The 2D array of `Cell` objects representing the board's grid.
     */
    public Cell[][] getGrid() {
        return grid;
    }
}
