/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaesarCipher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Neticius
 */
public class HitList implements Encryptable {

    List<String> targets = new ArrayList<>();
    boolean currentlyEncrypted;
    char currentKey;
    
    public HitList() {
       System.out.println("ENTER VICTIMS");
       Scanner enter = new Scanner(System.in);

       do {
           String k = enter.nextLine();
           if (k.equals("QUIT")) {
               break;
           }else {
               targets.add(k); 
           }
       } while(true);
       
       System.out.println("ENTER ENCRYPTION KEY(LETTER)");
       char character = enter.nextLine().charAt(0);
       encrypt(character);
    }
    
    @Override
    public void encrypt(char key) {
        if (currentlyEncrypted) {
            int currentKey = (int)key - 65;
            System.out.println("Encryption Key: " + currentKey);
            for (int i = 0; i < targets.size(); i++) {
                String addThisWord = "";
                for (int j = 0; j < targets.get(i).length(); j++) {
                    char currentChar = targets.get(i).charAt(j);
                    if ((int)targets.get(i).charAt(j) == 32) {
                        addThisWord += ' ';
                    } else {
                        char encryptedChar = (char)((int)targets.get(i).charAt(j) + currentKey);
                        System.out.println(currentChar + " is comverted to: " + encryptedChar);
                        addThisWord += encryptedChar;
                    }
                }
                targets.set(i, addThisWord);
                System.out.println(targets);
            }
            currentlyEncrypted = true;
        } else {
            System.out.println("This is encrypted already!!");
        }
    }

    @Override
    public void decrypt(char key) {
        if (!currentlyEncrypted) {
            int currentKey = (int)key - 65;
            System.out.println("Encryption Key: " + currentKey);
            for (int i = 0; i < targets.size(); i++) {
                String addThisWord = "";
                for (int j = 0; j < targets.get(i).length(); j++) {
                    char currentChar = targets.get(i).charAt(j);
                    if ((int)targets.get(i).charAt(j) == 32) {
                        addThisWord += ' ';
                    } else {
                        char encryptedChar = (char)((int)targets.get(i).charAt(j) - currentKey);
                        System.out.println(currentChar + " is comverted to: " + encryptedChar);
                        addThisWord += encryptedChar;
                    }
                }
                targets.set(i, addThisWord);
                System.out.println(targets);
            }
            currentlyEncrypted = false;
        } else {
            System.out.println("This is unencrypted already!!");
        }
    }

    @Override
    public boolean isEncrypted() {
        return currentlyEncrypted;
    }
   
   public void addVictim(String victim) {
       targets.add(victim);
   }
   
   public void removeVictim(String victim){
       targets.remove(victim);
   }
   
   public String toString() {
       String output = "";

       System.out.println(output.join("\n", targets));
       return output.join("\n", targets);
   }
   
   public static void main(String[] args) {
       HitList hit = new HitList();
       System.out.println("\n\ntoString() of encryped names:\n\n");
       hit.toString();
       System.out.println("\n\nDecrypting Names:\n\n");
       hit.decrypt('C');
       System.out.println("\n\ntoString() of decryped names:\n\n");
       hit.toString();
       System.out.println("\n\nRemoving SAM SIGGS from list:\n\n");
       hit.removeVictim("SAM SIGGS");
       hit.toString();
   }
}
