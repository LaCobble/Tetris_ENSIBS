package Interfaces;

public interface TetrominoInterface {

    boolean canMoveLeft();

    boolean canMoveRight();

    boolean canRotate();

    boolean canFall();

    void moveLeft();

    void moveRight();

    void rotate();

    void fall();

    void getX();

    void getY();

    TetrominoTypeInterface getTetrominoType();

    int getRotation();
}
