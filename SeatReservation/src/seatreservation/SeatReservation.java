/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatreservation;
import Time.Time;
/**
 *
 * @author Neticius
 */
public abstract class SeatReservation {
    private char row;
    private int col;
    protected boolean complementary;
    
    public float getTicketPrice() {
        return -1; // Needs to be overridden
    }
    
    public void setComplementary(boolean complementary){
        this.complementary = complementary;
    }
    
    public char getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public SeatReservation(char row, int col){
        this.row = row;
        this.col = col;
    }
}
