import java.awt.Color;
public class Cell {
    public Boolean occupied = false;
    public Color color;

    public Color getColor(){
        return color;
    }
    public void setOccupied(Boolean occupied){
        this.occupied = occupied;
    }
    public Boolean getState(){
        return  occupied;
    }
    public void setColor(Color color){
        this.color=color;
    }

}
