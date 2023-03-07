/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used for the grid of the game.
 *
 */
public class Grid {

    // The grid is a 2D array of cells
    public Cell[][] cells;

    // The grid is a square
    private Integer dimension;

    // The grid is located at the top left corner of the screen
    private Integer x;
    private Integer y;

    /**
     * getter for dimension
     * @return dimension integer
     */
    public Integer getDimension() {
        return dimension;
    }

    * setter for dimension
     * @param dimension integer
     */
    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    /**
     * getter for x
     * @return x integer
     */
    public Integer getX() {
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
    public Integer getY() {
        return y;
    }

    /**
     * setter for y
     * @param y integer
     */
    public void setY(Integer y) {
        this.y = y;
    }

}