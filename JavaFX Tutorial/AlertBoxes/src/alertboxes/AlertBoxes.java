/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alertboxes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Siggs
 */
public class AlertBoxes extends Application {
  public static void main(String[] args) {
    launch(args);
  }
  
  Stage window;
  Button button;
  
  @Override
  public void start(Stage primaryStage) {
    window = primaryStage;
    window.setTitle("Title Here");

    button = new Button("Click me");
    button.setOnAction(e -> {
      boolean result = ConfirmBox.display("Title of Window", "Are you sure you want to send pics?");
      System.out.println(result);
    });

    StackPane layout2 = new StackPane();
    layout2.getChildren().add(button);
    Scene scene = new Scene(layout2, 300, 250);
    window.setScene(scene);
    window.show();
  }


  
}
