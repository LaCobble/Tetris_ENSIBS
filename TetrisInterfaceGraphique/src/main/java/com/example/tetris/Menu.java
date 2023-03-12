/** Author: P-Y
 * Date: 2023-02-16
 * Description: Menu class
 * Version: 1.0
 **/
package com.example.tetrisfx;

// GUI for a Tetris game menu, with buttons  (First : start, second : options (opened a new windows and close this windows), third : score (opened a new windows and close this windows),exit (close this windows))

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Menu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tetris");

        // animation for a big title "tetris" (with a background image)

        // alignement of the buttons "Start", "Options", "Score", "Exit"
        Button start = new Button("Start");
        Button options = new Button("Options");
        Button score = new Button("Score");
        Button exit = new Button("Exit");

        // action of the buttons "Start", "Options", "Score", "Exit"
        StackPane layout = new StackPane();
        layout.getChildren().add(start);
        layout.getChildren().add(options);
        layout.getChildren().add(score);
        layout.getChildren().add(exit);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

