/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assiagment3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Neticius
 */
public abstract class Shape implements Serializable{
    protected Point startPoint;
    protected Point controlPoint;
    private Color colour;
    
    public Shape() {
        
    }
    public Shape(Point startPoint) {
        
    }
    public Color getColour(){
        return colour;
    }
    public void setColour(Color colour){
        this.colour = colour;
    }
    public void setControlPoint(Point controlPoint) {
        
    }
    public void setStartPoint(Point startPoint) {
        
    }
    public Point getControlPoint() {
        return controlPoint;
    }
    public Point getStartPoint() {
        return startPoint;
    }
    public void draw(Graphics g) {
        
    }
    public String toString() {
        return "";
    }
}
