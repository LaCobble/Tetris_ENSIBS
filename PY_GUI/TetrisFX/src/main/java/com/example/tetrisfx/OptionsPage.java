/** Author: P-Y
 * Date: 2023-02-16
 * Description: options page class
 * Version: 1.0
 **/

package com.example.tetrisfx;

import java.io.IOException;
import java.io.InputStream;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;
import javafx.scene.Scene;

/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is the options page of the game
 *
 */
public class OptionsPage extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create a root node for the scene
        StackPane root = new StackPane();

        // Background
        try(InputStream is = Files.newInputStream(Paths.get("C:\\Users\\pierr\\Documents\\Code\\TetrisFX\\src\\main\\java\\com\\example\\tetrisfx\\BackgroundOption.png"))){
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(400);
            img.setFitHeight(200);
            root.getChildren().add(img);
        }
        catch(IOException e) {
            System.out.println("Couldn't load image");
        }

        // Create a VBox to hold the buttons
        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        // Combo box for level selection "Easy", "Medium", "Hard"
        ComboBox<String> levelComboBox = new ComboBox<>();
        levelComboBox.getItems().addAll("Easy", "Medium", "Hard");
        levelComboBox.setValue("Easy");

        // Create a button to go back to the start page
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Main main = new Main();
            try {
                main.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();

        });

        // Add the buttons to the VBox
        buttonBox.getChildren().addAll(levelComboBox, backButton);

        // Add the VBox to the root node
        root.getChildren().add(buttonBox);

        // Create a scene with the root node and set the size
        Scene scene = new Scene(root, 400, 200);

        // Set the scene on the primary stage
        primaryStage.getIcons().add(new Image("file:C:\\Users\\pierr\\Documents\\Code\\TetrisFX\\src\\main\\java\\com\\example\\tetrisfx\\ico.png"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Options");
        primaryStage.show();

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
