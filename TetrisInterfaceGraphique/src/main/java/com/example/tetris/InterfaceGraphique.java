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
    import javafx.scene.input.KeyCode;
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

        boolean downPressed = false;
        int c = 0;

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

            boardPane.setRotate(90);
            boardPane.setTranslateX(-219);
            boardPane.setTranslateY(+339);

            // Ajout d'un grand rectangle vide
            Rectangle bigRect = new Rectangle(385, 745);
            bigRect.setFill(null);
            bigRect.setStrokeWidth(20);
            bigRect.setStroke(Color.WHITE);

            // Chargement d'une image en fond
            Image image = new Image("https://images4.alphacoders.com/313/3136.jpg");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(1920);
            imageView.setFitHeight(1080);



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
            //primaryStage.setFullScreen(true);
            primaryStage.setScene(scene);
            primaryStage.show();

            game.startGame();
            board = game.getTetrisBoard().getBoard().getGrid();

            Timeline gameTimeline = new Timeline(
                    new KeyFrame(Duration.millis(500), event -> {
                        Tetromino oldTetromino = new Tetromino(game.getCurrentTetromino());
                        // If current tetromino cannot move down
                        if (!game.getCurrentTetromino().moveDown()) {
                            // Create new tetromino at top of the screen
                            game.replaceCurrentTetromino();

                        } else {
                            game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
                        }

                        // Line deletion

                        int c = 0;
                        for (int i : game.getTetrisBoard().checkLineCompletion()){
                            if (i == 1){
                                game.getTetrisBoard().clearLine(c);
                            }
                            else {c++;}
                        }

                    })
            );
            gameTimeline.setCycleCount(Animation.INDEFINITE);
            gameTimeline.play();
            // Ajout de la gestion des touches clavier
            scene.setOnKeyPressed(this::handleInput);

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
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    Rectangle rect = new Rectangle(35, 35);
                    rect.setTranslateX(j);
                    rect.setTranslateY(i);
                    if (board[i][j] != null) {
                        rect.setFill(board[i][j].getColor());
                    }
                    boardPane.add(rect, j, i);
                }
            }
        }

        public void handleInput(javafx.scene.input.KeyEvent keyEvent) {
            Tetromino oldTetromino = new Tetromino(game.getCurrentTetromino());
            KeyCode keyCode = keyEvent.getCode();

            switch (keyCode) {
                case D :
                    game.getCurrentTetromino().moveLeft();
                    game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
                    break;
                case Q :
                    game.getCurrentTetromino().moveRight();
                    game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
                    break;
                case S :
                    while (game.getCurrentTetromino().moveDown()){}
                    game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
                    game.replaceCurrentTetromino();
                    break;
                case Z :
                    game.getCurrentTetromino().rotateClockwise();
                    game.getTetrisBoard().updateGrid(oldTetromino, game.getCurrentTetromino());
                    break;
                default:
                    break;
            }
            // Mise à jour de la grille avec le nouveau tetromino


        }


        public static void main(String[] args) {
            launch(args);
        }

    }


