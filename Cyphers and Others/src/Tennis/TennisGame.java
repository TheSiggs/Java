/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tennis;

import java.util.Random;

/**
 *
 * @author Neticius
 */
public class TennisGame {
    int pointsServer = 0;
    int pointsReciever = 0;
    final public int SERVER = 1;
    final public int RECIEVER = 2;
    private String score = getScore();
    
    public TennisGame(){
        pointsServer = 0;
        pointsReciever = 0;
    }
    public String getScore() {
        if (pointsServer == pointsReciever && pointsServer == 4) {
            return "deuce";
        }
        return "Server " + convertPointsToScore(pointsServer) + 
           ": Reciever " + convertPointsToScore(pointsReciever);
    }
    public void givePoint(int player) {
        if (player == SERVER) {
            pointsServer += SERVER; 
        } else {
            pointsReciever += RECIEVER; 
        }
        System.out.println(score + " (" + pointsServer + ", " + pointsReciever + ")");
    }
    public boolean isWinner() {
        if (convertPointsToScore(pointsServer) == "game") {
            System.out.println("Server Wins");
            isWinner(SERVER);
            return true;
        } else if (convertPointsToScore(pointsReciever) == "game"){
            System.out.println("Reciever Wins");
            isWinner(RECIEVER);
            return true;
        }
        return false;
    }
    public boolean isWinner(int player){
        givePoint(player);
        return true;  
    }
    public String convertPointsToScore(int points) {
        String[] score = {"love", "15", "30", "40", "game"};
        return score[points];
    }
}
