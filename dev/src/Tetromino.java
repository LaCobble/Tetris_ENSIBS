import Enum.TetrominoType;
import Interfaces.TetrominoInterface;

import java.awt.*;

public class Tetromino implements TetrominoInterface {

    protected TetrominoType type;

    protected Point[] positions = new Point[4];

    protected int rotation = 0;

    protected Color color;

    public Tetromino(TetrominoType type) {
        switch (type) {
            case Z:
                color = Color.red;
                positions[0] = new Point(0, 3);
                positions[1] = new Point(0, 4);
                positions[2] = new Point(1, 4);
                positions[3] = new Point(1, 5);
                break;
            case L:
                color = Color.orange;
                positions[0] = new Point(1, 3);
                positions[1] = new Point(1, 4);
                positions[2] = new Point(1, 5);
                positions[3] = new Point(0, 5);
                break;
            case O:
                color = Color.yellow;
                positions[0] = new Point(0, 4);
                positions[1] = new Point(0, 5);
                positions[2] = new Point(1, 4);
                positions[3] = new Point(1, 5);
                break;
            case S:
                color = Color.green;
                positions[0] = new Point(1, 3);
                positions[1] = new Point(1, 4);
                positions[2] = new Point(0, 4);
                positions[3] = new Point(0, 5);
                break;
            case I:
                color = Color.cyan;
                positions[0] = new Point(0, 3);
                positions[1] = new Point(0, 4);
                positions[2] = new Point(0, 5);
                positions[3] = new Point(0, 6);
                break;
            case J:
                color = Color.blue;
                positions[0] = new Point(0, 4);
                positions[1] = new Point(1, 4);
                positions[2] = new Point(1, 5);
                positions[3] = new Point(1, 6);
                break;
            case T:
                color = Color.magenta;
                positions[0] = new Point(0, 4);
                positions[1] = new Point(0, 5);
                positions[2] = new Point(0, 6);
                positions[3] = new Point(1, 5);
                break;
        }
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
    public void moveDown() {

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
    public TetrominoType getTetrominoType() {
        return type;
    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateCounterClockwise() {

    }
}
