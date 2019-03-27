/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sehall
 */
public class SimpleEmptyGUI extends JPanel{
    public final int PANEL_WIDTH = 500;
    public final int PANEL_HEIGHT = 500;
    private JLabel label;
   
    public SimpleEmptyGUI() {
        super();   //invoke super class Jpanel constructor
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.WHITE);
        
        setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new GridLayout(4,3));
        JPanel output = new JPanel(new FlowLayout(1, 800, new JLabel().getHeight() + 10));
        
        JLabel out = new JLabel(" ");
        
        add(output, NORTH);
        add(buttons, CENTER);
        
        output.add(out);
    
        ArrayList<JButton> numbers = new ArrayList<JButton>();
        String[] nums = {"7","8","9","+","4","5","6","-","1","2","3","*","CLEAR","0","ENTER", "/"};
        
        
        for (String i : nums) {
            JButton current = new JButton("" + i);
            current.addActionListener(e -> {
                System.out.println("You clicked: " + current.getText());
                if (current.getText().equals("ENTER")) {
                    out.setText(out.getText());
                } else {
                    out.setText(out.getText() + current.getText());
                }
                if (current.getText().equals("CLEAR")){out.setText(" ");}
            });
            buttons.add(current);
        }    
        
    } // EOF

    public static void main(String[] args) {
        SimpleEmptyGUI myPanel = new SimpleEmptyGUI();
        JFrame frame = new JFrame("Assiagment 2"); //create frame to hold our JPanel subclass	
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

