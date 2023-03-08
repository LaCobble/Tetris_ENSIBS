package Interfaces;

import Enum.TetrominoType;



public interface TetrisBoardInterface {

    void initGrid();
    void update();

    void render();

    int checkLineCompletion();

    void clearLine(int y);


    TetrominoInterface[] generateTrominoOrder();

    int generationBalancedRandomNumbers();

    TetrominoInterface getActualTetromino();

    TetrominoInterface getNextTetromino();


    void aside();
}

