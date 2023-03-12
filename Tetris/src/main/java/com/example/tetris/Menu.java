package com.example.tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The Menu class represents the GUI for the main menu of the Tetris game.
 * It contains buttons to start the game, access options, view the score, and exit the game.
 *
 * @author P-Y
 * @version 1.0
 */
public class Menu extends Application {

    /**
     * This method creates the GUI for the main menu of the game.
     * It includes buttons to start the game, access options, view the score, and exit the game.
     *
     * @param primaryStage the primary stage to set the scene
     * @throws Exception if an error occurs during the creation of the GUI
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tetris");

        // alignment of the buttons "Start", "Options", "Score", "Exit"
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

    /**
     * The main method of the Menu class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
