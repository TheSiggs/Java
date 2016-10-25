/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borderpanelayouts;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Siggs
 */
public class BorderPaneLayouts extends Application {

  public static void main(String[] args) {
    launch(args);
  }
  
  Stage window;
  
  @Override
  public void start(Stage primaryStage) {
    window = primaryStage;
    window.setTitle("Title Here");
    
    HBox topMenu = new HBox();
    Button buttonA = new Button("File");
    Button buttonB = new Button("Edit");
    Button buttonC = new Button("View");
    topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
    
    VBox leftMenu = new VBox();
    Button buttonD = new Button("D");
    Button buttonE = new Button("E");
    Button buttonF = new Button("F");
    leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
    
    BorderPane borderPane = new BorderPane();
    borderPane.setTop(topMenu);
    borderPane.setLeft(leftMenu);
    

    Scene scene = new Scene(borderPane, 300, 250);
    window.setScene(scene);
    window.show();
  }
  
}
