/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.template;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Neticius
 */
public class GUITemplate extends JPanel{
    
    GUITemplate() {
        super();   //invoke super class Jpanel constructor
        setPreferredSize(new Dimension(500, 500));
        setLayout(new BorderLayout());
        
    }
    
    //EOF
    public static void main(String[] args) {
        GUITemplate myPanel = new GUITemplate();
        JFrame frame = new JFrame("setTitle"); //create frame to hold our JPanel subclass	
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
    }
    
}
