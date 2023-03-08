/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used for the grid of the game.
 *
 */
public class Grid {

    public Cell[][] grid;
    private int dimensionX;
    private int dimensionY;
    private int x;
    private int y;

    public Grid(int dimensionX, int dimensionY){
        grid = new Cell[dimensionX][dimensionY];
    }
    public int getDimensionX() {
        return dimensionX;
    }
    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimension(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }
    // The grid is a 2D array of cells
    public Cell[][] cells;

    // The grid is a square
    private int dimension;

    // The grid is located at the top left corner of the screen


    /**
     * getter for dimension
     * @return dimension integer
     */
    public int getDimension() {
        return dimension;
    }

    /** setter for dimension
     * @param dimension integer
     */
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    /**
     * getter for x
     * @return x integer
     */
    public int getX() {

        return x;
    }

    /**
     * setter for x
     * @param x integer
     */
    public void setX(Integer x) {
        this.x = x;
    }


    /**
     * getter for y
     * @return y integer
     */
    public int getY() {

        return y;
    }

    /**
     * setter for y
     * @param y integer
     */
    public void setY(int y) {
        this.y = y;
    }

    public Cell[][] getGrid() {
        return grid;
    }

}