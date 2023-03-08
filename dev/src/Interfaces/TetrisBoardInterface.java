package Interfaces;

import Enum.TetrominoType;



public interface TetrisBoardInterface {


    void update();

    void render();

    int[] checkLineCompletion();

    void clearLine(int y);


    int generationBalancedRandomNumbers();

    TetrominoInterface getActualTetromino();

    TetrominoInterface getNextTetromino();

    void setTetrominoOrder();
    void aside();
}

