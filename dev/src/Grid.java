/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used for the grid of the game.
 *
 */
public class Grid {

    // The grid is a 2D array of cells
    private Cell[][] grid;

    private int dimensionX;
    private int dimensionY;
    private int x;
    private int y;

    public Grid(int dimensionX, int dimensionY){
        grid = new Cell[dimensionX][dimensionY];
    }
    /**
     * getter for dimensionX
     * @return dimensionX int
     */
    public int getDimensionX() {
        return dimensionX;
    }
    /**
     * getter for dimensionY
     * @return dimensionY int
     */
    public int getDimensionY() {
        return dimensionY;
    }

    /** setter for dimension
     * @param dimensionX int and dimensionY int
     */

    public void setDimension(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    /**
     * getter for x
     * @return x int
     */
    public int getX() {
        return x;
    }
    /**
     * getter for y
     * @return y int
     */
    public int getY() {
        return y;
    }

    /**
     * setter for x
     * @param x int
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * setter for y
     * @param y int
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * getter for y
     * @return grid Cell[][]
     */

    public Cell[][] getGrid() {
        return grid;
    }

}