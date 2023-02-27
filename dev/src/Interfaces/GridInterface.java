package Interfaces;

public interface GridInterface {
    Boolean isCellOccupied( Integer x,Integer y);
    Integer getDimension();
    Integer getX();
    Integer getY();
    TetrominoTypeInterface getTypeTetromino();
}