import java.awt.Color;
import Enum.TetrominoType;
import Interfaces.CellInterface;


/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used to create a Cell object, which is a cell of the game. It is used to create the 7 different pieces of the game.
 *
 **/
public class Cell {

    // Attributes
    // The cell is occupied or not
    private Boolean occupied;

    // The color of the cell
    private Color color;

    private Point point;

    public Cell(Tetromino tetromino,int x, int y) {
        this.color = tetromino.getColor();
        this.occupied = true;
        this.point = new Point(x,y);
    }

    /**
     * getter of the cell color
     * @return the color of the cell
     */
    public Color getColor(){
        return color;
    }

    /**
     * setter of the cell state
     * @param occupied of the cell
     */
    public void setOccupied(Boolean occupied){
        this.occupied = occupied;
    }

    /**
     * getter of the cell state
     * @return the state of the cell
     */
    public Boolean getState(){
        return  occupied;
    }

    /**
     * setter of the cell color
     * @param color of the cell
     */
    public void setColor(Color color){
        this.color=color;
    }

    /**
     * getter of the cell point
     * @return the point of the cell
     */
    public Point getPoint() {
        return point;
    }
    /**
     * setter of the cell point
     * @param point of the cell
     */
    public void setPoint(Point point) {
        this.point = point;
    }
}
