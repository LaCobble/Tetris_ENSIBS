import Interfaces.TetrisBoardInterface;
import Interfaces.TetrominoInterface;
import Enum.TetrominoType;
import java.util.Arrays;
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
    private Grid grid;

    // The score of the game
    private Integer lineCompleted;

    // The number of tetris
    private boolean pause;

    // The type of tetromino
    private final TetrominoType[] tetrominoOrder = TetrominoType.values();

    // The order of tetromino
    private Integer order;

    // Tetromino aside
    private Tetromino asideTetromino;

    /**
     * refresh the board
     */
    @Override
    public void update() {

    }

    /**
     * render the board
     */
    @Override
    public void render() {

    }

    /**
     * check if a line is completed
     * @return true if the line is completed
     */
    @Override
    public Integer checkLineCompletion() {
        return null;
    }

    /**
     * allow to clear a line
     */
    @Override
    public void clearLine() {

    }

    /**
     * allow to add a tetris
     */
    @Override
    public void addTetris() {

    }

    @Override
    public TetrominoInterface[] generateTrominoOrder() {
        return null;
    }

    /**
     * swap
     * @param A array
     * @param i int
     * @param j int
     */
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * shuffle a array
     * @param A array
     */
    public static void shuffle(int[] A)
    {
        // read array from the highest index to lowest
        for (int i = A.length - 1; i >= 1; i--)
        {
            Random rand = new Random();

            // generate a random number `j` such that `0 <= j <= i`
            int j = rand.nextInt(i + 1);

            // swap the current element with the randomly generated index
            swap(A, i, j);
        }
    }

    /**
     * generation of balanced random numbers
     * @return a random number
     */
    @Override
    public int generationBalancedRandomNumbers() {
        int[] A = {0, 1, 2, 3, 4, 5, 6 };
        shuffle(A);
        return A[0];
    }

    /**
     * get the actual tetromino
     * @return the actual tetromino
     */
    @Override
    public TetrominoType getActualTetromino() {
        TetrominoType element = tetrominoOrder[generationBalancedRandomNumbers()];
        return element;
    }

    /**
     * get the next tetromino
     * @return the next tetromino
     */
    @Override
    public TetrominoType getNextTetromino() {
        TetrominoType element = tetrominoOrder[generationBalancedRandomNumbers()];
        return element;
    }

    /**
     * get the aside tetromino
     * @return the aside tetromino
     */
    @Override
    public void fall() {

    }

    /**
     * get the aside tetromino
     * @return the aside tetromino
     */
    @Override
    public void aside() {

    }

}
