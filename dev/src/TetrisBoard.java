import Interfaces.TetrisBoardInterface;
import Interfaces.TetrominoInterface;
import Enum.TetrominoType;

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
    private Grid grid ;

    // The score of the game
    private Integer lineCompleted;

    // The number of tetris
    private boolean pause;

    // The type of tetromino
    private List<Tetromino> tetrominoOrder;


    // The order of tetromino
    private Integer order;

    // Tetromino aside
    private Tetromino asideTetromino;



    public TetrisBoard() {
        grid = new Grid(4, 4);

    }



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
    public int checkLineCompletion() {
        return 0;
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


    public void clearLine(int y) {
        Cell[][] gride = grid.getGrid();
        for (int i = 0; i < grid.getDimensionX(); i++) {
            gride[i][y] = null;
        }
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
    public Tetromino getActualTetromino() {
        return tetrominoOrder.get(generationBalancedRandomNumbers());
    }

    /**
     * get the next tetromino
     * @return the next tetromino
     */
    @Override
    public Tetromino getNextTetromino() {
        return tetrominoOrder.get(generationBalancedRandomNumbers());
    }


    /**
     * get the aside tetromino
     * @return the aside tetromino
     */
    @Override
    public void aside() {

    }

    public void setTetrominoOrder(){
        for (TetrominoType i : TetrominoType.values()){
            tetrominoOrder.add(new Tetromino(i));
        }
    }

}
