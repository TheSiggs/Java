/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import assiagment3.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Neticius
 */
public class Square extends Shape{
    protected Point startPoint;
    protected Point controlPoint;
    private Color colour;
    private boolean filled; 
    
    public Square() {
        super();
        this.startPoint = new Point(0,0);
        this.controlPoint = new Point(0,0);
    }
    public Square(Point startPoint, boolean filled) {
        super();
        this.startPoint = startPoint;
        this.colour = getColour();
        this.filled = filled;
    }
    @Override
    public void setControlPoint(Point controlPoint) {
        this.controlPoint = controlPoint;
    }
    @Override
    public void setColour(Color colour){
        this.colour = colour;
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(colour);
        int x1 = (int)startPoint.getX();
        int y1 = (int)startPoint.getY();
        int x2 = (int)controlPoint.getX();
        int y2 = (int)controlPoint.getY();
        int width = (int)controlPoint.getX() - x1;
        int height = (int)controlPoint.getY() - y1;

//        System.out.println(x1 +","+ y1 +","+ x2+","+y2);        
        if (filled) {
            g.fillRect(x1, y1, width, width);
        } else {
            g.drawLine(x1, y1, x2, y1);
            g.drawLine(x1, y2, x2, y2);
            g.drawLine(x1, y1, x1, y2);
            g.drawLine(x2, y1, x2, y2);
            
        }
    }
    @Override
    public String toString() {
        return "This is a Square!";
    }
}
