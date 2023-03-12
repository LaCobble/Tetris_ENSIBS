package com.example.tetris;

import com.example.tetris.Interfaces.TetrisBoardInterface;
import com.example.tetris.Enum.TetrominoType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is the board of the game
 */
public class TetrisBoard implements TetrisBoardInterface {

    // The grid of the game
    private Board board;
    private Cell[][] grid;

    // The score of the game
    private int lineCompleted;

    // The list of all tetromino
    private List<Tetromino> tetrominoOrder = new ArrayList<>();

    // Tetromino aside
    private Tetromino asideTetromino;

    private static TetrisBoard instance;


    public TetrisBoard() {
        board = new Board();
        grid = new Board().getGrid();
        setTetrominoOrder();
    }

    public static TetrisBoard getInstance() {
        if (instance == null) {
            instance = new TetrisBoard();
        }
        return instance;
    }

    /**
     * refresh the board
     */
    @Override
    public void updateGrid(Tetromino oldTetromino, Tetromino newTetromino) {

        for (int i = 0; i < oldTetromino.positions.length; i++) {
            board.deleteCell(oldTetromino.positions[i].getX(), oldTetromino.positions[i].getY());
        }
        addTetrominoToBoard(newTetromino);
    }

    /**
     * check if a line is completed
     *
     * @return 1 if the line is completed
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
     * clear a line
     * and goes down 1 all cells
     */
    public void clearLine(int Y) {
        System.out.println("ok");
        for (int x = 0; x < Board.colDimension; x++) {
            board.deleteCell(x,Y);
            for (int y = Y ; y >= 1; y--){
            board.moveCell(x,y-1,x,y);
            }
        }
        System.out.println("Line " + Y + " deleted.");
    }


    /**
     * swap
     * @param A array
     * @param i int
     * @param j int
     */
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * shuffle an array
     *
     * @param A array
     */
    public static void shuffle(int[] A) {
        // read array from the highest index to lowest
        for (int i = A.length - 1; i >= 1; i--) {
            Random rand = new Random();

            // generate a random number `j` such that `0 <= j <= i`
            int j = rand.nextInt(i + 1);

            // swap the current element with the randomly generated index
            swap(A, i, j);
        }
    }

    /**
     * generation of balanced random numbers
     *
     * @return a random number
     */
    @Override
    public int generationBalancedRandomNumbers() {
        int[] A = {0, 1, 2, 3, 4, 5, 6};
        shuffle(A);
        return A[0];
    }

    /**
     * get the actual tetromino
     *
     * @return the actual tetromino
     */
    @Override
    public Tetromino generateTetromino() {
        return tetrominoOrder.get(generationBalancedRandomNumbers());
    }

    /**
     * get the next tetromino
     *
     * @return the next tetromino
     */
    @Override
    public Tetromino getNextTetromino() {
        return tetrominoOrder.get(generationBalancedRandomNumbers());
    }

    public void setTetrominoOrder() {
        for (TetrominoType i : TetrominoType.values()) {
            tetrominoOrder.add(new Tetromino(i));
        }
    }

    public void addTetrominoToBoard(Tetromino tetromino){
        for (int i=0; i<4;i++){
            Point point = tetromino.positions[i];
            board.addCell(tetromino, point.getX(), point.getY());
        }

    }

    public Board getBoard(){
        return board;
    }
}
