/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used for the grid of the game.
 *
 */
public class Board {

    // The grid is a 2D array of cells
    private Cell[][] grid;

    public static int dimensionX = 10;
    public static int dimensionY = 20;

    public Board(){
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

    public void updateGrid(Cell[][] grid){
        this.grid = grid;
    }

    public Cell[][] getGrid() {
        return grid;
    }
}