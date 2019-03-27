/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seatreservation;
import Time.Time;
import Time.Comparable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Neticius
 */
public class MovieSession implements Comparable<Time>{
    
    private String movieName;
    private char rating;
    private Time sessionTime;
    final int NUM_ROWS = 6;
    final int NUM_COLS = 8;
    private SeatReservation[][] sessionSeats;

    public MovieSession(String movieName, char rating, Time sessionTime) {
        this.movieName = movieName;
        this.rating = rating;
        this.sessionTime = sessionTime;       
        sessionSeats = new SeatReservation[NUM_ROWS][NUM_COLS];
        
        for (SeatReservation[] row : sessionSeats) {
            Arrays.fill(row, null);         
        }
    }
    
    public static int convertRowToIndex(char rowLetter) {
        char index[] = {'A','B','C','D','E','F','G','H'};
        for (int i = 0; i < 12; i++) {
            if (index[i] == rowLetter) {
                return i;
            }
        } 
        return -1;
    }
    
    public static char convertIndexToRow(int rowIndex) {
        char index[] = {'A','B','C','D','E','F','G','H'};
        return index[rowIndex];
    }
    
    public char getRating() {
        return rating;        
    }
    
    public String getMovieName() {
        return movieName;
    }
    
    public Time getSessionTime() {
        return sessionTime;
    }
    
    public SeatReservation getSeat(char row, int col) {
        return sessionSeats[convertRowToIndex(row)][col];
    }
    
    public boolean isSeatAvailable(char row, int col) {
        return sessionSeats[convertRowToIndex(row)][col] == null;
    }
    
    public boolean applyBookings(List<SeatReservation> reservations) {
        for(SeatReservation reservation : reservations) {
            if (!isSeatAvailable(reservation.getRow(), reservation.getCol())) { // Seat is unavalibe
                return false;
            }
            if (reservation instanceof ChildReservation && rating == 'M') { // Child is booking M rated
                return false;
            }
        }
        return true;
    }
    
    public void printSeats() {
        String seats;
        for (SeatReservation[] sessionSeat : sessionSeats) {
            seats = "";
            for (SeatReservation seatReservation : sessionSeat) {
                if (seatReservation == null) {
                    seats += "|_|";
                } else if (seatReservation instanceof AdultReservation) {
                    seats += "|A|";
                } else if (seatReservation instanceof ChildReservation) {
                    seats += "|C|";
                } else if (seatReservation instanceof ElderlyReservation) {
                    seats += "|E|";
                }
            }
            System.out.println(seats);
        }
    }
    
    @Override
    public int compareTo(Time e) {
        System.out.println("Not finished");
        return -1;
    }
    
    public static void main(String[] args) {
//        ArrayList<MovieSession> sessions = new ArrayList<>();
//        sessions.add(new MovieSession("Super Power Dare Die Team ", 'M', new Time(20)));
//        sessions.add(new MovieSession("Six Naked Pigs", 'R', new Time(2)));
//        sessions.add(new MovieSession("Die Hard: Mega Hard", 'M', new Time(10)));
//        sessions.add(new MovieSession("If You Leave Me, I Delete You", 'G', new Time(5)));
//        
////        MovieSession session = new MovieSession("The Black Nigger", 'M', new Time());
//        for(MovieSession session : sessions) {
//            System.out.println(session.getMovieName());
//            System.out.println(session.getRating());
//            System.out.println(session.getSeat('B', 2));
//            System.out.println(session.isSeatAvailable('B', 2));
//            session.printSeats();
//        }

    }
}
