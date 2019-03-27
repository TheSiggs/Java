/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import assiagment3.EnclosesRegion;
import assiagment3.Shape;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import shapes.*;

/**
 *
 * @author Nettis
 */
public class ShapeSketcher extends JPanel implements ActionListener, EnclosesRegion{
    
    private JButton setColourButton, saveButton, loadButton;
    private JRadioButton Line,Oval,Rect,Square;
    private JCheckBox fillElementBox;
    private Color paintColour;
    private DrawingPanel canvas;
    private boolean fillShape;
    private ArrayList<Shape> drawnShapes;
    
    ShapeSketcher() {
        super();   //invoke super class Jpanel constructor
        setPreferredSize(new Dimension(800, 500));
        setLayout(new BorderLayout());
        canvas = new DrawingPanel();
        //setBackground(Color.white);
        
        //Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.white);
        
        centerPanel.add(canvas);
        add(centerPanel, BorderLayout.CENTER);
        
        //West Panel
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(120,500));
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        add(westPanel, BorderLayout.WEST);
        
        //West Panel Elements
         setColourButton = new JButton("Change Colour"); //setColour
         
        ButtonGroup shapes = new ButtonGroup(); //shapes
        fillElementBox = new JCheckBox("Fill"); //fillBox 
        Line = new JRadioButton("Line Tool"); //Line
        Oval = new JRadioButton("Oval Tool"); //Oval
        Rect = new JRadioButton("Rect Tool"); //Rect
        Square = new JRadioButton("Square Tool"); //Square

        saveButton = new JButton("Save"); //Save
        loadButton = new JButton("Load"); //Load
        
        //EventListeners
        setColourButton.addActionListener(this);
        fillElementBox.addActionListener(this);
        Line.addActionListener(this);
        Oval.addActionListener(this);
        Rect.addActionListener(this);
        Square.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
           
        //Add to westPanel
        westPanel.add(setColourButton);
        
        westPanel.add(Box.createRigidArea(new Dimension(0,10))); //Space
        
        westPanel.add(fillElementBox);
        
        westPanel.add(Box.createRigidArea(new Dimension(0,20))); //Space
        
        shapes.add(Line);
        shapes.add(Oval);
        shapes.add(Rect);
        shapes.add(Square);

        westPanel.add(Line);
        westPanel.add(Oval);
        westPanel.add(Rect);
        westPanel.add(Square);
        
        westPanel.add(Box.createVerticalGlue()); //Space
        
        westPanel.add(saveButton);
        westPanel.add(loadButton);
    }//EOF
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource(); //Get name of element
        if (source == setColourButton) { //Set colour
            JColorChooser chooseColour = new JColorChooser();
            this.paintColour = chooseColour.showDialog(this, "Choose Colour", Color.BLACK);
            System.out.println(paintColour);
            
        } else if (source == loadButton) { //Load file
            JFileChooser loadThis = new JFileChooser();
//            loadThis.showDialog(this, "Load");
            int status = loadThis.showOpenDialog(null);
            if(status == JFileChooser.APPROVE_OPTION)
            {   
                try
                {   ArrayList<Shape> loadedShapes = loadShapesFromFile(loadThis.getSelectedFile());
                    drawnShapes.clear();
                    drawnShapes.add(new Rectangle());
                    drawnShapes.add(new Square());
                    drawnShapes.add(new Line());
                    drawnShapes.add(new Oval());
                    drawnShapes = loadedShapes;
                    System.out.println("LOADED SHAPES\n"+loadedShapes);
                }catch(IOException em)
                {   JOptionPane.showMessageDialog(null, em, "ERROR LOADING FILE", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex, "ERROR WITH OBJECT CAST", JOptionPane.ERROR_MESSAGE);
                }
                
            } 
            
        } else if (source == saveButton) { //Save file
            JFileChooser saveThis = new JFileChooser();
//            saveThis.showDialog(this, "Save");
            int status = saveThis.showSaveDialog(null);
            if(status == JFileChooser.APPROVE_OPTION)
            {   try 
                {   saveShapesToFile(drawnShapes, saveThis.getSelectedFile());
                }catch(IOException i)
                {   JOptionPane.showMessageDialog(null, i, "ERROR SAVING FILE", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } else if (source == fillElementBox) { //Fill element
            if (fillElementBox.isSelected()) {
                setFilled(true);
            } else {
                setFilled(false);
            }
            
        } else if (source == Line) { //Draw line
            System.out.println("Create Line");
            
        } else if (source == Oval) { //Draw oval
            System.out.println("Draw oval");
            
        } else if (source == Rect) { //Draw Rect 
            System.out.println("Draw rect");
            
        } else if (source == Square) { //Draw square
            System.out.println("Draw square");
            
        }
        System.out.println(e.getActionCommand()+" has been clicked\n\n"); 
        repaint();
    }//EOF
    
    @Override
    public void setFilled(boolean filled){
        fillShape = filled;
        System.out.println("Fill shape: "+filled);
    }

    public void saveShapesToFile(ArrayList<Shape> list, File f) throws IOException
    {   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeInt(list.size());
        for(Shape c:list)
            oos.writeObject(c);  
        oos.flush();
        oos.close();      
    }
    
    public ArrayList<Shape> loadShapesFromFile(File f) throws IOException,ClassNotFoundException
    {   ArrayList<Shape> list = new ArrayList<>();
        Shape c = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        int size = ois.readInt();
        drawnShapes.clear();

        for(int i=0;i<size;i++)
        {    c = (Shape)ois.readObject();
             list.add(c);
        }   
        ois.close();
        return list;
    }
    //Inner Class for the canvas
    private class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener 
    {   
        Shape line, oval, rect, square;
        Point p = new Point();
        
        public DrawingPanel()
        {   super();
            setPreferredSize(new Dimension(680,500));
            setBackground(Color.WHITE);
            addMouseListener(this);
            addMouseMotionListener(this);
            
            rect = new Rectangle();
            square = new Square();
            line = new Line();
            oval = new Oval();
            drawnShapes = new ArrayList();
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for (Shape drawnShape : drawnShapes) {
                System.out.println("shape drawn");
                drawnShape.draw(g);
            }
            try {
                rect.draw(g);
                square.draw(g);
                line.draw(g);
                oval.draw(g);
            } catch (Exception e) {
                System.err.println("Error occured: " + e);
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //Create new shape
            //Set startPoint
            
            if (Rect.isSelected()) {
                Point p = new Point(e.getX(), e.getY());
                rect = new Rectangle(p, fillShape);
                rect.setColour(paintColour);
                rect.setStartPoint(p);
                rect.setControlPoint(p);
                System.out.println("New Rectangle at "+ e.getX() + ", " + e.getY());
            
            } else if (Square.isSelected()) {
                Point p = new Point(e.getX(), e.getY());
                square = new Square(p, fillShape);
                square.setColour(paintColour);
                square.setStartPoint(p);
                square.setControlPoint(p);
                System.out.println("New Square at "+ e.getX() + ", " + e.getY());
                
            } else if (Line.isSelected()) {
                Point p = new Point(e.getX(), e.getY());
                line = new Line(p);
                line.setColour(paintColour);
                line.setStartPoint(p);
                line.setControlPoint(p);
                System.out.println("New Line at "+ e.getX() + ", " + e.getY());
                
            } else if (Oval.isSelected()) {
                Point p = new Point(e.getX(), e.getY());
                oval = new Oval(p, fillShape);
                oval.setColour(paintColour);
                oval.setStartPoint(p);
                oval.setControlPoint(p);
                System.out.println("New Oval at "+ e.getX() + ", " + e.getY());
            } else {
                System.out.println("Nothing selected");
            }
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            Point p = new Point(e.getX(), e.getY());
            if (Rect.isSelected()) {
                rect.setControlPoint(p);
            } else if (Square.isSelected()) {
                square.setControlPoint(p);
            } else if (Line.isSelected()) {
                line.setControlPoint(p);
            } else if (Oval.isSelected()) {
                oval.setControlPoint(p);
            } else {
                System.out.println("No shape selected");
            }    
            repaint();
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            if (Rect.isSelected()) {
                rect.setControlPoint(new Point(e.getX(), e.getY()));
                drawnShapes.add(rect);
                System.out.println("Rectangle Created!");
                
            }else if (Square.isSelected()) {
                square.setControlPoint(new Point(e.getX(), e.getY()));
                drawnShapes.add(square);
                System.out.println("Square Created!");
                
            } else if (Line.isSelected()) {
                line.setControlPoint(new Point(e.getX(), e.getY()));
                drawnShapes.add(line);
                System.out.println("Line Created!");
                
            } else if (Oval.isSelected()) {
                oval.setControlPoint(new Point(e.getX(), e.getY()));
                drawnShapes.add(oval);
                System.out.println("Oval Created!");
            }
            repaint();
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {}     
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mouseMoved(MouseEvent e) {}
    }//EOC
   
    public static void main(String[] args) {
        ShapeSketcher myPanel = new ShapeSketcher();
        JFrame frame = new JFrame("Paint.exe"); //create frame to hold our JPanel subclass	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(myPanel);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel
        frame.setResizable(false);
        //Position frame on center of screen 
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        frame.setLocation(new Point((screenWidth / 2) - (frame.getWidth() / 2), (screenHeight / 2) - (frame.getHeight() / 2)));
        //show the frame	
        frame.setVisible(true);
    }//EOF
} //EOC
