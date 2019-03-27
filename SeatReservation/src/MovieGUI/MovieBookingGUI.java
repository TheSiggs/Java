/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import seatreservation.SeatReservation;
import Time.Time;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import seatreservation.MovieSession;

/**
 *
 * @author Neticius
 */
public class MovieBookingGUI extends JPanel implements ActionListener{
    private ArrayList<MovieSession> sessions = new ArrayList<>();
    private JButton[][] buttons;
    private JList list;
    private DefaultListModel model;
    private JRadioButton child,adult,elderly;
    private JTextField sumField;
    private JButton book, exit, cancel;
    private JScrollPane pane;
    private JLabel movieTitle = new JLabel("Movies N Chill");
    private JCheckBox complmentary;
    
    private int numberOfElderly = 0;
    private int numberOfAdults = 0;
    private int numberOfChildren = 0;
    private float costOfAdult = 12.50f;
    private float costOfChild = 8.00f;
    private float costOfElderly = 12.50f - (12.50f * 0.3f);
    
    final int ROW = 8;
    final int COL = 6;
    
    public MovieBookingGUI()
    {   super(new BorderLayout());
        char[] lettersp = {'A','B','C','D','E','F','G','H','I','J','K'};
//    Movie Seats
        JPanel centerPanel = new JPanel(new GridLayout(ROW,COL));
        centerPanel.setPreferredSize(new Dimension(500,500));
        buttons = new JButton[ROW][COL];     
        for(int i=0;i<ROW;i++)
        {   for(int j=0;j<COL;j++)
            {   buttons[i][j] = new JButton(lettersp[i]+","+j);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBackground(Color.lightGray);
                centerPanel.add(buttons[i][j]);
            }
        }
        add(centerPanel, BorderLayout.CENTER);
        
        // Movie title if I can be bothered making it change dynamicly
        JPanel northPanel = new JPanel();
        northPanel.add(movieTitle);
        add(northPanel,BorderLayout.NORTH);
        
        // Movie List
        model = new DefaultListModel();
        list = new JList(model);
        list.setFixedCellWidth(200);
        list.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println(sessions.get(e.getFirstIndex()).getMovieName() + " Selected");
            sessions.get(e.getFirstIndex()).printSeats();
            
        }
    });
        
//        model.addElement(new String("HELLO NIGGER"));
        
        sessions.add(new MovieSession("Super Power Dare Die Team ", 'M', new Time(20)));
        sessions.add(new MovieSession("Six Naked Pigs", 'R', new Time(2)));
        sessions.add(new MovieSession("Die Hard: Mega Hard", 'M', new Time(10)));
        sessions.add(new MovieSession("If You Leave Me, I Delete You", 'G', new Time(5)));
        
        for (MovieSession session : sessions) {
            model.addElement(session.getMovieName());            
        }
        
        
       // list.setPreferredSize(new Dimension(50,500));
        pane = new JScrollPane(list);
        add(pane,BorderLayout.EAST);
        
        
        
        //Types of seats
        JPanel southPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        child = new JRadioButton("Child");
        adult = new JRadioButton("Adult");
        elderly = new JRadioButton("Elderly");
        complmentary = new JCheckBox("Complmentary");
        
        // Other Buttons
        exit = new JButton("Exit");
        cancel = new JButton("Cancel");
        book = new JButton("Book");
        book.addActionListener(this);
        exit.addActionListener(this);
        cancel.addActionListener(this);

        group.add(child);
        group.add(adult);
        group.add(elderly);
        
        southPanel.add(child);
        southPanel.add(adult);
        southPanel.add(elderly);
        southPanel.add(complmentary);
        
        southPanel.add(exit);
        southPanel.add(cancel);
        southPanel.add(book);
        add(southPanel,BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {   
        if (e.getSource() == book) {
            System.out.println("Seats Booked!");
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (buttons[i][j].getBackground().equals(new Color(255,255,0))) {
                        numberOfChildren++;
                    }
                    if (buttons[i][j].getBackground().equals(new Color(255,255,255))) {
                        numberOfAdults++;
                    }
                    if (buttons[i][j].getBackground().equals(new Color(0,0,255))) {
                        numberOfElderly++;                 
                    }
                }
            }
            String sen = "Booking " + numberOfChildren + " children, " + numberOfAdults + " adults and " + numberOfElderly + " elderly ";
            String comeTo = "That comes to: " + ((float)numberOfChildren*costOfChild + numberOfAdults*costOfAdult + numberOfElderly*costOfElderly);
            showMessageDialog(null, sen + comeTo);
        }

        
        if(e.getSource() == cancel)System.out.println("Canceled Booking!");
        else if(e.getSource() == exit)System.out.println("Quitting");
        else
        {   
            Object source = e.getSource();
            if (source instanceof JButton && child.isSelected()) {
                JButton button = (JButton) source;
                button.setBackground(Color.yellow); 
            } else if (source instanceof JButton && adult.isSelected()) {
                JButton button = (JButton) source;
                button.setBackground(Color.white);
            } else if (elderly.isSelected()) {
                JButton button = (JButton) source;
                button.setBackground(Color.blue);
            }
            System.out.println("BUTTON WITH LABEL "+e.getActionCommand()+" PRESSED ");
            
            
            
            book.setBackground(new JButton().getBackground());
            exit.setBackground(new JButton().getBackground());
            cancel.setBackground(new JButton().getBackground());
        }
    }
     
    
    public static void main(String[] args) {
        MovieBookingGUI myPanel = new MovieBookingGUI();
        JFrame frame = new JFrame("Movies N Chill"); //create frame to hold our JPanel subclass
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(myPanel);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel
        //Position frame on center of screen 
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        frame.setLocation(new Point((screenWidth / 2) - (frame.getWidth() / 2), 
                    (screenHeight / 2) - (frame.getHeight() / 2)));
	//show the frame
        frame.setVisible(true);
    }
}
