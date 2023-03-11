/** Author: P-Y
 * Date: 2023-02-16
 * Description: tetris page class
 * Version: 1.0
 **/

package com.example.tetrisfx;

import java.io.IOException;
import java.io.InputStream;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.*;
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
 * This class is used for game page
 *
 */
public class StartPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game");
        primaryStage.getIcons().add(new Image("file:C:\\Users\\pierr\\Documents\\Code\\TetrisFX\\src\\main\\java\\com\\example\\tetrisfx\\ico.png"));

        // Create a root node for the scene
        StackPane root = new StackPane();

        // Create a scene with the root node and set the size
        Scene scene = new Scene(root, 600, 600);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public StartPage() {
        String nameWindows = "StartPage";
    }
}
