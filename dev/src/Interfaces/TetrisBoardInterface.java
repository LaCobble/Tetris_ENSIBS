package Interfaces;

public interface TetrisBoardInterface {
    void update();

    void render();

    Integer checkLineCompletion();

    void clearLine();

    void updateSpeed();

    boolean isPause();

    void addTetris();

    TetrominoInterface[] generateTrominoOrder();

    Integer generationBalancedRandomNumbers();

    TetrominoInterface getActualTetromino();

    TetrominoInterface getNextTetromino();

    void fall();

    void aside();
}

