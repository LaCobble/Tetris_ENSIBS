import Interfaces.TetrisBoardInterface;
import Enum.TetrominoType;

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

    private TetrisBoard() {
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
    public void update() {
        board.updateGrid(grid);
    }
    ///public void update(Color[][] matrix, int row, int column, Color newColor) {
    //    matrix[row][column] = newColor;
    //}

    /**
     * render the board
     */
    @Override
    public void render() {

    }

    /**
     * check if a line is completed
     *
     * @return 1 if the line is completed
     */
    @Override
    public int[] checkLineCompletion() {
        int[] R = new int[Board.dimensionY];
        for (int y = 0; y < Board.dimensionY; y++) {
            int columnCounter = 0;
            for (int x = 0; x < Board.dimensionX; x++) {
                if (board.getGrid()[x][y] != null) {
                    columnCounter++;
                } else if (columnCounter == Board.dimensionY) {
                    R[y] = 1;
                }
            }
        }
        return R;
    }

    /**
     * clear a line
     * and goes down 1 all cells
     */
    public void clearLine(int Y) {
        for (int x = 0; x < Board.dimensionX; x++) {
            board.getGrid()[x][Y] = null;
            for (int y = Y; y < Board.dimensionY; y++) {
                if (board.getGrid()[x][y] != null) {
                    board.getGrid()[x][y] = board.getGrid()[x][y + 1];
                }
            }
        }
    }


    /**
     * swap
     *
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
    public Tetromino getActualTetromino() {
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


    /**
     * get the aside tetromino
     *
     * @return the aside tetromino
     */
    @Override
    public void aside() {

    }

    public void setTetrominoOrder() {
        for (TetrominoType i : TetrominoType.values()) {
            tetrominoOrder.add(new Tetromino(i));
        }
    }

    public void addTetrominoToGrid(Tetromino tetromino){
        for (int i=0; i<4;i++){
            Point point = tetromino.positions[i];
            board.addCell(tetromino, point.getX(), point.getY());
        }
    }

    public Board getGrid(){
        return board;
    }
}
