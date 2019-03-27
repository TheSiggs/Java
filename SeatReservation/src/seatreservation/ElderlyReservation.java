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
public class ElderlyReservation extends SeatReservation{

    
    public ElderlyReservation(char row, int col) {
        super(row, col);
    }
    
    @Override
    public float getTicketPrice() {
        if (complementary) {
            return 0f;
        } else {
            return (12.50f * 0.3f) - 12.50f;
        }
    }
    
    
    
}
