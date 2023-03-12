package com.example.tetris;

import com.example.tetris.Interfaces.TetrisBoardInterface;
import com.example.tetris.Enum.TetrominoType;

import java.util.Random;


/**
 * This class represents the board of the Tetris game.
 * It is responsible for managing the grid of cells that make up the game board, adding and removing tetrominos,
 * checking for completed lines, and generating new tetrominos.
 *
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 */
public class TetrisBoard implements TetrisBoardInterface {

    /**
     * The main grid of cells that make up the game board.
     */
    private Board board;

    /**
     * A 2D array representing the same cells as the board.
     */
    private Cell[][] grid;

    /**
     * The singleton instance of this class.
     */
    private static TetrisBoard instance;

    /**
     * An array containing all possible types of tetrominos.
     */
    private static final TetrominoType[] ALL_TYPES = TetrominoType.values();

    public TetrisBoard() {
        board = new Board();
        grid = new Board().getGrid();
    }

    /**
     * Returns a single instance of the TetrisBoard class.
     * @return instance
     */
    public static TetrisBoard getInstance() {
        if (instance == null) {
            instance = new TetrisBoard();
        }
        return instance;
    }

    /**
     * This method updates the board so that the tetromino takes its new position.
     * It first deletes the old tetromino from the board and then adds the new one.
     *
     * @param oldTetromino The old Tetromino.
     * @param newTetromino The new Tetromino.
     */
    @Override
    public void updateGrid(Tetromino oldTetromino, Tetromino newTetromino) {

        for (int i = 0; i < oldTetromino.positions.length; i++) {
            board.deleteCell(oldTetromino.positions[i].getX(), oldTetromino.positions[i].getY());
        }
        addTetrominoToBoard(newTetromino);
    }

    /**
     * This method checks if a line is completed.
     *
     * @return An array indicating which lines are completed (1) and which are not (0).
     */
    @Override
    public int[] checkLineCompletion() {
        int[] r = new int[Board.lineDimension + 1];
        for (int y = Board.lineDimension - 1; y > 0; y--) {
            int columnCounter = 0;
            for (int x = 0; x < Board.colDimension; x++) {
                if (getBoard().getGrid()[x][y] != null) {
                    columnCounter++;
                }
                if (columnCounter == Board.colDimension) {
                    r[y] = 1;
                }
            }
        }
        return r;
    }

    /**
     * This method removes an entire line.
     *
     * @param Y The Y-coordinate of the line to be removed.
     */
    public void clearLine(int Y) {
        for (int x = 0; x < Board.colDimension; x++) {
            board.deleteCell(x,Y);
            for (int y = Y ; y >= 1; y--){
            board.moveCell(x,y-1,x,y);
            }

        }

    }

    /**
     * This method generates a new random tetromino.
     *
     * @return The newly generated tetromino or null if no new tetromino can fit.
     */
    @Override
    public Tetromino generateTetromino() {
        Random random = new Random();
        int randomIndex = random.nextInt(ALL_TYPES.length);
        TetrominoType type = ALL_TYPES[randomIndex];
        Tetromino tetromino = new Tetromino(type);
        for (Point position : tetromino.getPositions()) {
            int x = position.getX();
            int y = position.getY();
            if (getBoard().getGrid()[x][y] != null) {
                return null;
            }
        }
        return tetromino;
    }

    /**
     * This method adds a tetromino to the board
     *
     * @param tetromino The tetromino to add to the board.
     */
    public void addTetrominoToBoard(Tetromino tetromino){
        for (int i=0; i<4;i++){
            Point point = tetromino.positions[i];
            board.addCell(tetromino, point.getX(), point.getY());
        }
    }

    /**
     * Returns the board.
     *
     * @return board The board of the game.
     */
    public Board getBoard(){
        return board;
    }
}
