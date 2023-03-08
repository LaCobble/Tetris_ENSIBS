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

    private Cell cell;

    private int dimensionX = 10;
    private int dimensionY = 20;

    public Grid(){
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
     * getter for grid
     * @return grid Cell[][]
     */

    public Cell[][] getGrid() {
        return grid;
    }

    public void addCell(Tetromino tetromino,int x, int y ){
        assert (dimensionX >= x && x >= 0);
        assert (dimensionY >= y && y >= 0);
        cell = new Cell(tetromino,x,y);
        grid[x][y] = cell;
    }
}