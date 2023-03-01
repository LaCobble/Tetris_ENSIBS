import java.awt.Color;
import Interfaces.BlockInterface;
public class Block implements BlockInterface {
    private Color color;

    public void setColor(Color color){
        this.color = color;
    }
    @Override
    public Color getColor(){
        return color;
    }
}

