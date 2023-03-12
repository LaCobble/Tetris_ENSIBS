package com.example.tetris;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class represents the score page of the Tetris game.
 * It displays the high scores achieved by players, including the top three and the remaining seven scores.
 * Players can return to the start page by clicking the "Back" button.
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 */
public class ScorePage extends Application {

        // Sample scores
        private static final String[][] SCORES = {
                {"ROOT", "9999"},
                {"Bob", "1503"},
                {"Paul", "1345"},
                {"David", "940"},
                {"Alexandre", "704"},
                {"Frank", "650"},
                {"Grace", "403"},
                {"Lucie", "324"},
                {"Isaac", "100"},
                {"Lucas", "1"}
        };

        // private static String[][] SCORES;

        /**
         * Starts the score page of the game.
         *
         * @param primaryStage the primary stage for this application, onto which the application scene can be set.
         */
        @Override
        public void start(Stage primaryStage) {

                /*try {
                        SCORES = HighScoreManager.readScores();
                } catch (IOException e) {
                        e.printStackTrace();
                }*/

                // create a winner podium with a grid pane and rectangles
                GridPane podiumPane = new GridPane();
                podiumPane.setHgap(20);
                podiumPane.setAlignment(Pos.CENTER);

                // Create a rectangle for the gold medal
                Rectangle goldRectangle = new Rectangle(300, 60);
                goldRectangle.setFill(Color.WHITE);
                goldRectangle.setStroke(Color.GOLD);
                goldRectangle.setStrokeWidth(2);
                podiumPane.add(goldRectangle, 1, 0);

                // Create a rectangle for the silver medal
                Rectangle silverRectangle = new Rectangle(220, 40);
                silverRectangle.setFill(Color.WHITE);
                silverRectangle.setStroke(Color.SILVER);
                silverRectangle.setStrokeWidth(2);
                podiumPane.add(silverRectangle, 0, 1);

                // Create a rectangle for the bronze medal
                Rectangle bronzeRectangle = new Rectangle(180, 20);
                bronzeRectangle.setFill(Color.WHITE);
                bronzeRectangle.setStroke(Color.BROWN);
                bronzeRectangle.setStrokeWidth(2);
                podiumPane.add(bronzeRectangle, 2, 2);

                // Create podium labels
                Label goldLabel = new Label("  1er : " + SCORES[0][0] + " - " + SCORES[0][1]);
                goldLabel.setStyle("-fx-text-fill: gold; -fx-font-size: 28px;");
                Label silverLabel = new Label("  2em : " + SCORES[1][0] + " - " + SCORES[1][1]);
                silverLabel.setStyle("-fx-text-fill: silver; -fx-font-size: 24px;");
                Label bronzeLabel = new Label("  3em : " + SCORES[2][0] + " - " + SCORES[2][1]);
                bronzeLabel.setStyle("-fx-text-fill: #CD7F32; -fx-font-size: 20px;");

                // Add labels to podium pane
                podiumPane.add(goldLabel, 1, 0);
                podiumPane.add(silverLabel, 0, 1);
                podiumPane.add(bronzeLabel, 2, 2);

                // Create a VBox for the remaining scores
                VBox scoresBox = new VBox();
                scoresBox.setSpacing(10);
                scoresBox.setAlignment(Pos.CENTER_LEFT);
                scoresBox.setPadding(new Insets(20, 0, 0, 0));

                // Create score labels and add them to the VBox
                for (int i = 3; i < 10; i++) {
                        Label scoreLabel = new Label((i + 1) + ". " + SCORES[i][0] + " - " + SCORES[i][1]);
                        scoreLabel.setStyle("-fx-font-size: 18px;");
                        scoresBox.getChildren().add(scoreLabel);
                }

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

                // Set the style of the button
                backButton.setAlignment(Pos.BOTTOM_CENTER);
                backButton.setPadding(new Insets(0, 0, 0, 0));
                backButton.setStyle("-fx-font-size: 18px;");
                backButton.setPrefSize(80, 20);

                // Create an HBox to hold both the podium and the scores
                HBox root = new HBox();
                root.setSpacing(40);
                root.setAlignment(Pos.CENTER);
                root.setPadding(new Insets(40));
                root.getChildren().addAll(podiumPane, scoresBox);
                root.getChildren().add(backButton);

                // Create the scene and show the stage
                Scene scene = new Scene(root, 1200, 350);
                primaryStage.getIcons().add(new Image("ico.png"));
                primaryStage.setScene(scene);
                primaryStage.setTitle("Scores");
                primaryStage.show();
        }

        public static void main(String[] args) {
                launch(args);
        }
}
