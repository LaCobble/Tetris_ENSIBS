    package com.example.tetris;
    import javafx.animation.Animation;
    import javafx.animation.KeyFrame;
    import javafx.animation.Timeline;
    import javafx.application.Application;
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


    public class TetrisApplication extends Application {

        Game game;

        Cell[][] board;

        GridPane boardPane = new GridPane();

        int score;

        Label scoreLabel;

        int speed;

        Timeline gameTimeline;
        Timeline displayTimeline;
        StackPane root;
        Scene scene;


        @Override
        public void start(Stage primaryStage) {
            game = new Game();
            speed = Main.getSpeed();

            scoreLabel = new Label("SCORE :  " + score);
            scoreLabel.setFont(new Font("Arial", 32));
            scoreLabel.setTextFill(Color.WHITE);
            scoreLabel.setTranslateX(-400);
            scoreLabel.setTranslateY(0);


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

            boardPane.setRotate(90);
            boardPane.setTranslateX(-219);
            boardPane.setTranslateY(+339);

            Rectangle bigRect = new Rectangle(385, 745);
            bigRect.setFill(null);
            bigRect.setStrokeWidth(20);
            bigRect.setStroke(Color.WHITE);

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

            // Affichage de la scène
            primaryStage.setTitle("TetrisGame");

            // primaryStage.setFullScreen(true);
            primaryStage.getIcons().add(new Image("ico.png"));
            primaryStage.setScene(scene);
            primaryStage.show();

            game.start();
            board = game.getTetrisBoard().getBoard().getGrid();

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
            // Update board object
            board = game.getTetrisBoard().getBoard().getGrid();
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
                case D -> game.getCurrentTetromino().moveLeft();
                case Q -> game.getCurrentTetromino().moveRight();
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
