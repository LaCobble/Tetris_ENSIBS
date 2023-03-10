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

    private int dimensionX = 10;
    private int dimensionY = 20;

    public Grid(){
        grid = new Cell[dimensionX][dimensionY];
    }

    /**
     * Adds a new cell with the specified Tetromino object to the grid at the given x and y coordinates.
     * @param tetromino The Tetromino object to add to the cell.
     * @param x The x-coordinate of the cell in the grid.
     * @param y The y-coordinate of the cell in the grid.
     */
    public void addCell(Tetromino tetromino,int x, int y ){
        assert (dimensionX >= x && x >= 0);
        assert (dimensionY >= y && y >= 0);
        grid[x][y] = new Cell(tetromino,x,y);
    }

    /**
     * Getter for a cell at specified coordinates.
     * @param x The x-coordinate of the cell to get.
     * @param y The y-coordinate of the cell to get.
     * @return The Cell object at the specified coordinates.
     */
    public Cell getCell(int x, int y) {
        assert (dimensionX >= x && x >= 0);
        assert (dimensionY >= y && y >= 0);
        return grid[x][y];
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

    /**
     * getter for grid
     * @return grid Cell[][]
     */

    public Cell[][] getGrid() {
        return grid;
    }

    /** setter for dimension
     * @param dimensionX int and dimensionY int
     */
    public void setDimension(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public void updateGrid(Cell[][] grid){
        this.grid = grid;
    }
}