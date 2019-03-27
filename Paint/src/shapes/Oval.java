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

/**
 *
 * @author Neticius
 */
public class Oval extends Shape{
    protected Point startPoint;
    protected Point controlPoint;
    private Color colour;
    private boolean filled;    
    
    public Oval() {
        super();
        this.startPoint = new Point(1,1);
        this.controlPoint = new Point(1,1);
    }
    public Oval(Point startPoint, boolean filled) {
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
        int r = (int)controlPoint.getX() - (int)startPoint.getX()/(int)startPoint.getY();
        int x = x1-(r/2);
        int y = y1-(r/2);
//        System.out.println(x1 +","+ y1 +","+ r);      
        
        if (filled) {
            g.fillRoundRect(x, y, r, r, r, r);
        } else {
            g.drawOval(x, y, r, r);
            
            
        }
    }
    @Override
    public String toString() {
        return "This is a Oval!";
    }
}
