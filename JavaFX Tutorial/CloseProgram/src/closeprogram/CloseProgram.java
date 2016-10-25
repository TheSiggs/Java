/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closeprogram;

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
public class CloseProgram extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }
  
  Stage window;
  Button button;
  
  @Override
  public void start(Stage primaryStage) {
    window = primaryStage;
    window.setTitle("Title Here");
    window.setOnCloseRequest(e -> {
      e.consume();
      closeProgram();
    });

    button = new Button("Close Program");
    button.setOnAction(e -> closeProgram());


    StackPane layout2 = new StackPane();
    layout2.getChildren().add(button);
    Scene scene = new Scene(layout2, 300, 250);
    window.setScene(scene);
    window.show();
  }
  
  private void closeProgram() {
    Boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
    if(answer)
      window.close();
  }
}
