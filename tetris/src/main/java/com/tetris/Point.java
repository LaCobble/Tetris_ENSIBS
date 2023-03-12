package com.tetris;


import com.tetris.Interfaces.PointInterface;

/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class represents a point in a 2D space.
 *
 */
public class Point implements PointInterface {

    /** The x coordinate of the point */
    private int x;

    /** The y coordinate of the point */
    private int y;


    /**
     * Constructor of the class Point
     * @param x The x coordinate of the point
     * @param y The y coordinate of the point
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * set the x coordinate of the point
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set the y coordinate of the point
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get the x coordinate of the point
     * @return x
     */
    @Override
    public int getX(){
        return this.x;
    }

    /**
     * get the y coordinate of the point
     * @return y
     */
    @Override
    public int getY(){
        return this.y;
    }

}