package com.tetris;

import com.tetris.Interfaces.BlockInterface;
import javafx.scene.paint.Color;


/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used to create a block
 *
 */
public class Block implements BlockInterface {

    // Attributes
    // The color of the block
    private Color color;

    /**
     * setter of the color
     * @param color The color of the block
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * getter of the color
     * @return The color of the block
     */
    @Override
    public Color getColor(){
        return color;
    }
}

