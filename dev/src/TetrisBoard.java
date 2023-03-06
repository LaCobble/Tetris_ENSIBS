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
    private List<Tetromino> tetrominoOrder;


    //
    private Integer order;

    // Tetromino aside
    private Tetromino asideTetromino;

    
    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    @Override
    public Integer checkLineCompletion() {
        return null;
    }

    @Override
    public void clearLine() {

    }

    @Override
    public void addTetris() {

    }

    @Override
    public TetrominoInterface[] generateTrominoOrder() {
        return null;
    }
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    // Function to shuffle an array `A[]`
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
    @Override
    public int generationBalancedRandomNumbers() {
        int[] A = {0, 1, 2, 3, 4, 5, 6 };
        shuffle(A);
        return A[0];
    }

    @Override
    public Tetromino getActualTetromino() {
        return tetrominoOrder.get(generationBalancedRandomNumbers());
    }

    @Override
    public Tetromino getNextTetromino() {
        return tetrominoOrder.get(generationBalancedRandomNumbers());
    }

    @Override
    public void fall() {

    }

    @Override
    public void aside() {

    }

    public void setTetrominoOrder(){
        for (TetrominoType i : TetrominoType.values()){
            tetrominoOrder.add(new Tetromino(i));
        }
    }

}
