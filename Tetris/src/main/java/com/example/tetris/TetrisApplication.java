    package com.example.tetris;

    import javafx.animation.Animation;
    import javafx.animation.KeyFrame;
    import javafx.animation.Timeline;
    import javafx.scene.Scene;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.layout.GridPane;
    import javafx.scene.layout.StackPane;
    import javafx.scene.paint.Color;
    import javafx.scene.input.KeyCode;
    import javafx.scene.shape.Rectangle;
    import javafx.scene.text.Font;
    import javafx.stage.Stage;
    import javafx.util.Duration;
    import javafx.application.Application;

    import java.io.IOException;
    import java.util.Scanner;

    public class TetrisApplication extends Application {

        Game game;

        GridPane boardPane = new GridPane();

        int score;

        Label scoreLabel;

        int speed;

        Timeline gameTimeline;

        Timeline displayTimeline;

        StackPane root;

        Scene scene;

        String pseudo;

        /**
         * The start method is called when the application is launched. It initializes
         * the game and sets up the user interface.
         *
         * @param primaryStage The primary stage for the application.
         */
        @Override
        public void start(Stage primaryStage) {
            game = new Game();
            speed = Main.getSpeed();

            // Set up the score label
            scoreLabel = new Label("SCORE :  " + score);
            scoreLabel.setFont(new Font("Arial", 32));
            scoreLabel.setTextFill(Color.WHITE);
            scoreLabel.setTranslateX(-400);
            scoreLabel.setTranslateY(0);

            // Set up the pause button
            Button btn = new Button("PAUSE");
            btn.setOnAction(e -> {
                if (game.getIsRunning()) {
                    btn.setText("RESUME");
                    gameTimeline.stop();
                    displayTimeline.stop();
                    game.pause();
                } else {
                    btn.setText("PAUSE");
                    gameTimeline.play();
                    displayTimeline.play();
                    game.resume();
                }
            });

            btn.setPrefWidth(100);
            btn.setPrefHeight(50);
            btn.setTranslateX(-400);
            btn.setTranslateY(50);

            // Set up the game board
            boardPane.setRotate(90);
            boardPane.setTranslateX(-219);
            boardPane.setTranslateY(+339);

            Rectangle bigRect = new Rectangle(385, 745);
            bigRect.setFill(null);
            bigRect.setStrokeWidth(20);
            bigRect.setStroke(Color.WHITE);

            // Set up the background image
            Image image = new Image("3136.jpg");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(1920);
            imageView.setFitHeight(1080);

            root = new StackPane();
            root.getChildren().add(0, imageView);
            root.getChildren().add(boardPane);
            root.getChildren().add(bigRect);
            root.getChildren().add(scoreLabel);
            root.getChildren().add(btn);

            scene = new Scene(root, 1400, 800);

            displayTimeline = new Timeline(
                    new KeyFrame(Duration.millis(10), event -> {
                        updateUI();
                    })
            );

            displayTimeline.setCycleCount(Animation.INDEFINITE); // Boucle infinie
            displayTimeline.play();

            primaryStage.setTitle("TetrisGame");

            // primaryStage.setFullScreen(true);
            primaryStage.getIcons().add(new Image("ico.png"));
            primaryStage.setScene(scene);
            primaryStage.show();

            game.start();

            gameTimeline = new Timeline(
                    new KeyFrame(Duration.millis(speed), event -> {
                        Tetromino oldTetromino = new Tetromino(game.getCurrentTetromino());
                        // If current tetromino cannot move down
                        if (!game.getCurrentTetromino().moveDown()) {
                            // Create new tetromino (can be null if no new
                            Tetromino newTetromino = game.getTetrisBoard().generateTetromino();
                            if (newTetromino != null) {
                                game.setCurrentTetromino(newTetromino);
                            } else {
                                game.end();
                                System.exit(0);
                                /*try {
                                    HighScoreManager.getInstance().writeScore(pseudo,score); // export doesn't work
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }*/
                            }
                        } else {
                            game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
                        }

                        // Line deletion
                        int c = 0;
                        for (int i : game.getTetrisBoard().checkLineCompletion()){
                            if (i == 1){
                                game.getTetrisBoard().clearLine(c);
                                score += 10;
                            }
                            else {c++;}
                        }
                    })
            );
            gameTimeline.setCycleCount(Animation.INDEFINITE);
            gameTimeline.play();

            // Handle key events
            scene.setOnKeyPressed(this::handleInput);
        }

        private void updateUI() {
            // Update score
            scoreLabel.setText("SCORE :  " + score);
            // Clear old board
            boardPane.getChildren().clear();
            // Retrieve board object
            Cell[][] board = game.getTetrisBoard().getBoard().getGrid();
            // Update UI with the
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    Rectangle cell = new Rectangle(35, 35);
                    cell.setTranslateX(j);
                    cell.setTranslateY(i);
                    if (board[i][j] != null) {
                        cell.setFill(board[i][j].getColor());
                    }
                    boardPane.add(cell, j, i);
                }
            }
        }

        public void handleInput(javafx.scene.input.KeyEvent keyEvent) {
            Tetromino oldTetromino = new Tetromino(game.getCurrentTetromino());
            KeyCode keyCode = keyEvent.getCode();

            switch (keyCode) {
                case D -> game.getCurrentTetromino().moveRight();
                case Q -> game.getCurrentTetromino().moveLeft();
                case S -> {
                    while (game.getCurrentTetromino().moveDown()) {}
                }
                case Z -> game.getCurrentTetromino().rotateClockwise();
                default -> {
                }
            }
            // Update the tetromino's position in the board
            game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
        }

        public static void main(String[] args) {
            launch(args);
        }

    }
