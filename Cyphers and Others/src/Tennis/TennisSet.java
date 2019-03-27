/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tennis;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Neticius
 */
public class TennisSet extends TennisGame{
    private int scoreA = 0;
    private int scoreB = 0;
    private String playerA;
    private String playerB;
    private TennisGame currentGame;
    private boolean servingplayerA;
    
    public TennisSet(String playerA, String playerB) {
        servingplayerA = true;
        playGame(playerA, playerB);
    }
    public void playSet(String playerA, String playerB) {
        Random rand = new Random();
        pointsServer = 0;
        pointsReciever = 0;
//        rand.nextBoolean();
//        while (pointsServer < 5 && pointsReciever < 5) {
        for (int i = 0; i < 5; i++) {
            if (rand.nextBoolean() == true) {
                System.out.println(playerA + " won!");
                isWinner(SERVER);
            } else {
                System.out.println(playerB + " won!");
                isWinner(RECIEVER);
            }
        }

    }
    public void playGame(String playerA, String playerB) {
        for (int i = 1; i < 6; i++) {
            System.out.println("\n-----------------------------------\nGame: "+i+
               "\n-----------------------------------");
            playSet(playerA, playerB);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter player 1");
        String playerA = in.nextLine();
        System.out.println("Enter player 2");
        String playerB = in.nextLine();
        System.out.println("--------------------------------");
        TennisSet Game = new TennisSet(playerA, playerB);
    }
}
