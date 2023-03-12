package com.example.tetris;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CreditPage extends Application {

    private static final String[] CREDITS = {
            "This game was created by, ",
            "this awesome squad :",
            "Ben Nasrallah Ahmed",
            "Latour Morgan",
            "Maucourt Pierre-Yves",
            "Saudemont Thomas"
    };

    private static final Duration ANIMATION_DURATION = Duration.seconds(5);
    private static final Duration INITIAL_DELAY = Duration.seconds(3);

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(
                new Color(0, 0, 0, 1),
                CornerRadii.EMPTY,
                javafx.geometry.Insets.EMPTY
        )));

        Label creditLabel = new Label();
        creditLabel.setTextFill(Color.WHITE);
        creditLabel.setFont(Font.font(20));
        creditLabel.setOpacity(0.0);

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

        StackPane bottomPane = new StackPane(backButton);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new javafx.geometry.Insets(10));

        root.getChildren().addAll(creditLabel, bottomPane);

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        new CreditsTransition(creditLabel).play();
    }

    private static class CreditsTransition extends Transition {
        private final Label label;
        private int index = -1;

        public CreditsTransition(Label label) {
            this.label = label;
            setCycleDuration(ANIMATION_DURATION);
            setDelay(INITIAL_DELAY);
        }

        @Override
        protected void interpolate(double v) {
            if (v > (1.0 / CREDITS.length) * (index + 1)) {
                index++;
                if (index >= CREDITS.length) {
                    stop();
                    return;
                }
                label.setText(CREDITS[index]);
                label.setOpacity(1.0);
            }
            label.setTranslateY(-label.getHeight() * (v - (1.0 / CREDITS.length) * index) / (1.0 / CREDITS.length));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
