/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexconverter;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.util.Arrays;
/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
  
 String[] eng = {
   "A","B","C","D","E","F","G","H","I","J","K","L","M","O","P","Q","R","S","T","U","V","W","X","Y","Z",
   "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "
 };
 
 String[] hex = {
   "41","42","43","44","45","46","47","48","49","4A","4B","4C","4D","4E","4F","50","51","52","53","54","55","56","57","58","59","5A",
   "61","62","63","64","65","66","67","68","69","6A","6B","6C","6D","6E","6F","70","71","72","73","74","75","76","77","78","79","7A","20"
 };
  
  @FXML 
  private TextField hexText;
  private TextField englishText;
  
  @FXML
  private void convertToEnglish(ActionEvent event) {
    System.out.println("Converted to English!");   
    
  }
  
  @FXML
  private void convertToHex(ActionEvent event){
    System.out.println("Converted to Hex!");
       
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
}
