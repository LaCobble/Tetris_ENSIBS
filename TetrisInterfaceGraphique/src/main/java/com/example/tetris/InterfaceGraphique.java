package com.example.tetris;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class InterfaceGraphique extends Application {

    Game game;
    Cell[][] board;
    GridPane boardPane = new GridPane();
    int score;
    Text scoreText = new Text();

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Start application.");
        game = new Game();

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
        Rectangle bigRect = new Rectangle(400, 800);
        bigRect.setFill(null);
        bigRect.setStrokeWidth(20);
        bigRect.setStroke(Color.WHITE);

        // Chargement d'une image en fond
        Image image = new Image("https://images4.alphacoders.com/313/3136.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1400);
        imageView.setFitHeight(800);

        // Ajout de la grille à une scène
        StackPane root = new StackPane();
        root.getChildren().add(0, imageView);
        root.getChildren().add(boardPane);
        root.getChildren().add(bigRect); // Ajout du rectangle vide à la scène
        root.getChildren().add(text);
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 1400, 800);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(100), event -> {
                    updateUI();
                })
        );

        timeline.setCycleCount(Animation.INDEFINITE); // Boucle infinie
        timeline.play();

        // Affichage de la scène
        primaryStage.setTitle("TetrisGame");
        primaryStage.setScene(scene);
        primaryStage.show();

        game.startGame();
        board = game.getTetrisBoard().getBoard().getGrid();

        Timeline gameTimeline = new Timeline(
                new KeyFrame(Duration.millis(1000), event -> {
                    Tetromino oldTetromino = new Tetromino(game.getCurrentTetromino());
                    game.getCurrentTetromino().moveDown();
                    game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 20; j++) {
                            System.out.print(board[i][j] + " | ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                })
        );
        gameTimeline.setCycleCount(Animation.INDEFINITE);
        gameTimeline.play();

    }

    private void updateUI() {
        // Mettre à jour le texte
        scoreText.setText("SCORE :  " + score);
        // Effacer les anciennes cases
        boardPane.getChildren().clear();
        // Mettre à jour les éléments de l'interface graphique en fonction de l'état du jeu
        score = game.getScore();
        board = game.getTetrisBoard().getBoard().getGrid();

        // Mettre à jour les cases de la grille
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 20; j++) {
                if (board[i][j] != null) {
                    Color color = board[i][j].getColor();
                    Rectangle rect = new Rectangle(40, 40);
                    rect.setFill(color);
                    rect.setTranslateX(j + 650);
                    rect.setTranslateY(i);
                    boardPane.add(rect, j, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
