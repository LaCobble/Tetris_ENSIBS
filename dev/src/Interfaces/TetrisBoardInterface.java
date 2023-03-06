package Interfaces;

import Enum.TetrominoType;



public interface TetrisBoardInterface {
    void update();

    void render();

    Integer checkLineCompletion();

    void clearLine();


    void addTetris();

    TetrominoInterface[] generateTrominoOrder();

    int generationBalancedRandomNumbers();

    TetrominoInterface getActualTetromino();

    TetrominoInterface getNextTetromino();

    void fall();

    void aside();
}

