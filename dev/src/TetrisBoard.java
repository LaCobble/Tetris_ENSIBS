import Interfaces.TetrisBoardInterface;
import Interfaces.TetrominoInterface;

public class TetrisBoard implements TetrisBoardInterface {
    private Grid grid;
    private Integer lineCompleted;
    private Integer speed;
    private boolean pause;
    private Tetromino[] tetrominoOrder;
    private Integer order;
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
    public void updateSpeed() {

    }

    @Override
    public boolean isRunning() {

        return isRunning;
    }

    @Override
    public void addTetris() {

    }

    @Override
    public TetrominoInterface[] generateTrominoOrder() {
        return null;
    }

    @Override
    public Integer generationBalancedRandomNumbers() {
        return null;
    }

    @Override
    public Tetromino getActualTetromino() {
        return null;
    }

    @Override
    public Tetromino getNextTetromino() {
        return null;
    }

    @Override
    public void fall() {

    }

    @Override
    public void aside() {

    }
}
