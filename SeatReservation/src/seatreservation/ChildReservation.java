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
public class ChildReservation extends SeatReservation{
    
    public ChildReservation(char row, int col) {
        super(row, col);
    }
    
    @Override
    public float getTicketPrice() {
        if (complementary) {
            return 0;
        } else {
            return 8.00f;
        }
    }   
}
