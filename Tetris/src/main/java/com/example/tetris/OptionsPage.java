/** Author: P-Y
 * Date: 2023-02-16
 * Description: options page class
 * Version: 1.0
 **/

package com.example.tetris;

import javafx.application.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is the options page of the game
 *
 */
public class OptionsPage extends Application {
    String difficulty;

    @Override
    public void start(Stage primaryStage) {

        // Create a root node for the scene
        StackPane root = new StackPane();

        // Background
        ImageView img = new ImageView(new Image("BackgroundOption.png"));
        img.setFitWidth(400);
        img.setFitHeight(200);
        root.getChildren().add(img);

        // Create a VBox to hold the buttons
        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        // Combo box for level selection "Easy", "Medium", "Hard"
        ComboBox<String> levelComboBox = new ComboBox<>();
        levelComboBox.getItems().addAll("Easy", "Medium", "Hard","GodMode");
        levelComboBox.setValue("Easy");
        difficulty = levelComboBox.getValue();

        // Create a button to go back to the start page
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            String selectedLevel = levelComboBox.getValue();
            Main main = new Main();
            try {
                main.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
        });

        Button CreditButton = new Button("Credit");
        CreditButton.setOnAction(e -> {
            CreditPage creditPage = new CreditPage();
            try {
                creditPage.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            Stage stage = (Stage) CreditButton.getScene().getWindow();
            stage.close();
        });

        // Add the buttons to the VBox
        buttonBox.getChildren().addAll(levelComboBox, CreditButton, backButton);

        // Add the VBox to the root node
        root.getChildren().add(buttonBox);

        // Create a scene with the root node and set the size
        Scene scene = new Scene(root, 400, 200);

        // Set the scene on the primary stage
        primaryStage.getIcons().add(new Image("ico.png"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Options");
        primaryStage.show();

        // Show the primary stage
        primaryStage.show();

    }
    

    public int getSpeedOnOptionPage(){
        int result = 1000;
        switch (difficulty){
            case "Easy":{
                result = 1000;
            }
            case "Medium":{
                result = 750;
            }
            case "Hard":{
                result = 500;
            }
            case "GodMode":{
                result =250;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
