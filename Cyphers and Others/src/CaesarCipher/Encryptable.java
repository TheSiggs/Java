/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaesarCipher;

/**
 *
 * @author Neticius
 */
public interface Encryptable{
    public void encrypt(char key);
    public void decrypt(char key);
    public boolean isEncrypted();
}
