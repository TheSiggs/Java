/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Neticius
 */
public class SimpleSlotMachine {
    
    
    public static int[] pullLever() {
        Random rand = new Random();
        int rolls[] = {rand.nextInt(10),rand.nextInt(10),rand.nextInt(10)};
        return rolls;   
    }
    
    
    public static void main(String[] args){
        
        Scanner enter = new Scanner(System.in);
        int roll1, roll2, roll3;
        int loops = 0;

        System.out.println("PRESS ENTER TO TRY YOUR LUCK OR TYPE QUIT TO QUIT");
 
        do {
            String k = enter.nextLine();
            if (k.toUpperCase().equals("QUIT")){
                System.out.println("YOU HAVE PULLED THE LEVER " + loops
                + " TIMES!");
                break;
            } else {
                int[] rolls = pullLever();
                loops++;
                roll1 = rolls[0];
                roll2 = rolls[1];
                roll3 = rolls[2];
                System.out.format("%1d %1d %1d\n",roll1, roll2, roll3); 
                
                if (roll1 == roll2 && roll2 == roll3) {
                    System.out.println("JACKPOT");
                } else if (roll1 == roll2 || roll1 == roll3 || roll2 == roll3) {
                    System.out.println("SO CLOSE");
                }
                
            }
            
        } while(true); 
        
    }
}
