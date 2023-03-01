import Enum.TetrominoType;
import Interfaces.TetrominoInterface;

import javax.swing.text.Position;
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
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
                break;
            case L:
                color = Color.orange;
                positions[0] = new Point(3, 1);
                positions[1] = new Point(4, 1);
                positions[2] = new Point(5, 1);
                positions[3] = new Point(5, 0);
                break;
            case O:
                color = Color.yellow;
                positions[0] = new Point(4, 0);
                positions[1] = new Point(5, 0);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
                break;
            case S:
                color = Color.green;
                positions[0] = new Point(3, 1);
                positions[1] = new Point(4, 1);
                positions[2] = new Point(4, 0);
                positions[3] = new Point(5, 0);
                break;
            case I:
                color = Color.cyan;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(5, 0);
                positions[3] = new Point(6, 0);
                break;
            case J:
                color = Color.blue;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(3, 1);
                positions[2] = new Point(4, 1);
                positions[3] = new Point(5, 1);
                break;
            case T:
                color = Color.magenta;
                positions[0] = new Point(3, 0);
                positions[1] = new Point(4, 0);
                positions[2] = new Point(5, 0);
                positions[3] = new Point(4, 1);
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
    public boolean canMoveDown() {
        for (Point p : positions) {
            if (p.getY() == 9) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean canRotate() {
        return false;
    }

    @Override
    public void moveLeft() {
        for (Point p : positions) {
            p.setX(p.getX() - 1);
        }
    }

    @Override
    public void moveRight() {
        for (Point p : positions) {
            p.setX(p.getX() + 1);
        }
    }

    @Override
    public void moveDown() {
        for (Point p : positions) {
            p.setY(p.getY() - 1);
        }
    }

    @Override
    public void rotate() {
        assert this.canRotate();

    }

    @Override
    public void fall() {

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
