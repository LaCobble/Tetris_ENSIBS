package com.example.tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class InterfaceGraphique extends Application {


    Game game = new Game();

    TetrisBoard tetrisBoard = new TetrisBoard();
    Cell[][] grid ;
    int score = game.getScore();

    @Override
    public void start(Stage primaryStage) {


        tetrisBoard.addTetrominoToGrid(tetrisBoard.getNextTetromino());
        grid = tetrisBoard.getGrid();

        GridPane gridPane = new GridPane();
        // Ajout du texte
        Text text = new Text("SCORE :  " + score);
        text.setFont(new Font("Arial", 32));
        text.setFill(Color.WHITE);
        text.setTranslateX(-400);
        text.setTranslateY(0);

        // Ajout du bouton pause
        Button btn = new Button("PAUSE");
        btn.setOnAction(e -> {
            if (game.getisRunning()) {
                game.pause();
            } else {
                game.resume();
            }
        });
        btn.setPrefWidth(100);
        btn.setPrefHeight(50);
        btn.setTranslateX(-400);
        btn.setTranslateY(50);

        // Ajout d'un grand rectangle vide
        Rectangle bigRect = new Rectangle(380, 780);
        bigRect.setFill(null);
        bigRect.setStrokeWidth(20);
        bigRect.setStroke(Color.WHITE);

        // Chargement d'une image en fond
        Image image = new Image("https://images4.alphacoders.com/313/3136.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1600);
        imageView.setFitHeight(900);

        // Ajout de la grille à une scène
        StackPane root = new StackPane();
        root.getChildren().add(0, imageView);
        root.getChildren().add(gridPane);
        root.getChildren().add(bigRect); // Ajout du rectangle vide à la scène
        root.getChildren().add(text);
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 1400, 800);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j]!=null){
                    java.awt.Color color = grid[i][j].getColor();

                    Rectangle rect = new Rectangle(40, 40);
                    rect.setFill(color);
                    rect.setTranslateX(j * 40 - 180);
                    rect.setTranslateY(i * 40 - 360);
                    gridPane.add(rect, j, i);
                }
            }
        }

        // Affichage de la scène
        primaryStage.setTitle("TetrisGame");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
