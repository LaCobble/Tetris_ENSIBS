import Interfaces.TetrominoInterface;
import Interfaces.TetrominoTypeInterface;

public class Tetromino implements TetrominoInterface {

    protected TetrominoType type;

    protected Point[] positions;

    protected int rotation;

    public Tetromino(TetrominoType type) {
        
    }

    @Override
    public boolean canMoveLeft() {
        return false;
    }

    @Override
    public boolean canMoveRight() {
        return false;
    }

    @Override
    public boolean canRotate() {
        return false;
    }

    @Override
    public boolean canFall() {
        return false;
    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void rotate() {
        assert this.canRotate();

    }

    @Override
    public void fall() {

    }

    @Override
    public void getX() {

    }

    @Override
    public void getY() {

    }

    @Override
    public TetrominoTypeInterface getTetrominoType() {
        return null;
    }

    @Override
    public int getRotation() {
        return 0;
    }
}
