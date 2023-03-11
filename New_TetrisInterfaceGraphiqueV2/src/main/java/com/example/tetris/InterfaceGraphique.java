package com.example.tetris;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InterfaceGraphique extends Application {

    private static final int NUM_ROWS = 20;
    private static final int NUM_COLS = 10;
    private static final int CELL_SIZE = 30;
    private static final int ANGLE = 90;
    private static final int WIDTH = NUM_COLS * CELL_SIZE * 2;
    private static final int HEIGHT = NUM_ROWS * CELL_SIZE ;

    Game game;
    Cell[][] board;
    int score;
    GridPane boardPane;
    Text scoreText;

    @Override
    public void start(Stage primaryStage) {
        System.out.println("Start application.");
        game = new Game();

        boardPane = new GridPane();
        boardPane.setRotate(ANGLE);
        boardPane.setLayoutX(-(WIDTH / 4));
        boardPane.setLayoutY(0);

        // Ajout du texte
        scoreText = new Text("SCORE :  " + score);
        scoreText.setFont(new Font("Arial", 16));
        scoreText.setFill(Color.BLACK);
        scoreText.setTranslateX(-100);
        scoreText.setTranslateY(10);

        // Ajout de la grille à une scène
        StackPane root = new StackPane();
        root.getChildren().add(boardPane);
        //root.getChildren().add(bigRect);
        // Ajout du rectangle vide à la scène
        root.getChildren().add(scoreText);
        //root.getChildren().add(btn);
        // Create a new Scene with the game board as its root node
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(scene);
        primaryStage.show();


        /*
        // Ajout du bouton pause
        Button btn = new Button("PAUSE");
        btn.setOnAction(e -> {
            if (game.getisRunning()) {
                game.pause();
            } else {
                game.resume();
            }
        });

        */


        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(100), event -> {
                    updateUI();
                })
        );

        timeline.setCycleCount(Animation.INDEFINITE); // Boucle infinie
        timeline.play();

        game.startGame();
        board = game.getTetrisBoard().getBoard().getGrid();

        Timeline gameTimeline = new Timeline(
                new KeyFrame(Duration.millis(1000), event -> {
                    Tetromino oldTetromino = new Tetromino(game.getCurrentTetromino());
                    game.getCurrentTetromino().moveDown();
                    game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());

//                    // read keyBoard input and stock it in a variable
//                    KeyEvent keyEvent = new KeyEvent(null, null, KeyEvent.KEY_PRESSED);
//
//                    handleInput(keyEvent);


                    /**for (int i = 0; i < 10; i++) {
                     //                            System.out.print(board[i][j] +
                     for (int j = 0; j < 20; j++) { " | ");
                     }
                     //                        System.out.println();
                     }
                     //                    System.out.println();*/

                })
        );
        gameTimeline.setCycleCount(Animation.INDEFINITE);
        gameTimeline.play();

    }

    private void updateUI() {
        // Mettre à jour le texte
        // scoreText.setText("SCORE :  " + score);
        // Effacer les anciennes cases
        boardPane.getChildren().clear();
        // Mettre à jour les éléments de l'interface graphique en fonction de l'état du jeu
        score = game.getScore();
        board = game.getTetrisBoard().getBoard().getGrid();

        // Mettre à jour les cases de la grille
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 20; j++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                if (board[i][j] != null) {
                    cell.setFill(board[i][j].getColor());
                } else {
                    cell.setFill(Color.LIGHTGRAY);
                }

                boardPane.add(cell, j, i);
            }
        }
    }

    public void handleInput(KeyEvent event) {
        Tetromino oldTetromino = new Tetromino(game.getCurrentTetromino());
        switch (event.getCode()) {
            case LEFT:
                game.getCurrentTetromino().moveLeft();
                break;
            case RIGHT:
                game.getCurrentTetromino().moveRight();
                break;
            case DOWN:
                while (game.getCurrentTetromino().moveDown());
                break;
            case UP:
                currentTetromino.rotateClockwise();
                break;
            default:
                break;*/
        }
        game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
    }

    public static void main(String[] args) {
        launch(args);
    }


}
