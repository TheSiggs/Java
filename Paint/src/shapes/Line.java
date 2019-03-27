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
public class Line extends Shape{
    protected Point startPoint;
    protected Point controlPoint;
    private Color colour;
    
    public Line() {
        super();
        this.startPoint = new Point(1,1);
        this.controlPoint = new Point(1,1);
    }

    public Line(Point startPoint) {
        super();
        this.startPoint = startPoint;
        this.colour = getColour();
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
        int x = (int)startPoint.getX();
        int y = (int)startPoint.getY();
        int width = (int)controlPoint.getX();
        int height = (int)controlPoint.getY();
//        System.out.println(x +","+ y +","+ width+","+height); 
        g.drawLine(x, y, width, height);
    }
    @Override
    public String toString() {
        return "This is a Line!";
    }
}
