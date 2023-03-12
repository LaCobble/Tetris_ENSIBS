/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used to create the main page of the game
 *
 */

package com.example.tetris;

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

public class Main extends Application{

    private Parent createContent() {
        Pane root = new Pane();

        root.setPrefSize(1050, 600);

        try(InputStream is = Files.newInputStream(Paths.get("C:\\Users\\pierr\\Documents\\Code\\TetrisFX\\src\\main\\java\\com\\example\\tetrisfx\\tetris.jpg"))){
            ImageView img = new ImageView(new Image(is));
            img.setFitWidth(1050);
            img.setFitHeight(600);
            root.getChildren().add(img);
        }
        catch(IOException e) {
            System.out.println("Couldn't load image");
        }

        Title title = new Title ("Tetris");
        title.setTranslateX(22);
        title.setTranslateY(200);

        // add listener to the menu items
        MenuBox vbox = new MenuBox(
                new MenuItem("Start"),
                new MenuItem("Options"),
                new MenuItem("Score"),
                new MenuItem("Quit")
        );
        vbox.setTranslateX(100);
        vbox.setTranslateY(300);

        root.getChildren().addAll(title,vbox);

        return root;

    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());
        primaryStage.getIcons().add(new Image("file:C:\\Users\\pierr\\Documents\\Code\\TetrisFX\\src\\main\\java\\com\\example\\tetrisfx\\ico.png"));
        primaryStage.setTitle("Tetris - Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static class Title extends StackPane{
        public Title(String name) {
            Rectangle bg = new Rectangle(375, 60);
            bg.setStroke(Color.WHITE);
            bg.setStrokeWidth(2);
            bg.setFill(null);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg,text);
        }
    }

    private static class MenuBox extends VBox{
        public MenuBox(MenuItem...items) {
            getChildren().add(createSeperator());

            for(MenuItem item : items) {
                getChildren().addAll(item, createSeperator());
            }
        }

        private Line createSeperator() {
            Line sep = new Line();
            sep.setEndX(210);
            sep.setStroke(Color.DARKGREY);
            return sep;
        }

    }

    private static class MenuItem extends StackPane{
        public MenuItem(String name) {
            LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {
                    new Stop(0, Color.DARKBLUE),
                    new Stop(0.1, Color.BLACK),
                    new Stop(0.9, Color.BLACK),
                    new Stop(1, Color.DARKBLUE)

            });

            Rectangle bg = new Rectangle(200,30);
            bg.setOpacity(0.4);

            Text text = new Text(name);
            text.setFill(Color.DARKGREY);
            text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD,20));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg, text);
            setOnMouseEntered(event -> {
                bg.setFill(gradient);
                text.setFill(Color.WHITE);

            });

            setOnMouseExited(event -> {
                bg.setFill(Color.BLACK);
                text.setFill(Color.DARKGREY);
            });
            setOnMousePressed(event -> {
                bg.setFill(Color.DARKVIOLET);

            });

            setOnMouseReleased(event -> {
                bg.setFill(gradient);
            });

            setOnMouseClicked(event -> {
                switch(name) {

                    case "Start":
                        // redirect to the StartPage and close the menu
                        StartPage startPage = new StartPage();
                        startPage.start(new Stage());
                        // close the menu
                        Stage stage = (Stage) this.getScene().getWindow();
                        stage.close();
                        break;

                    case "Options":

                        // redirect to OptionsPage and close the menu
                        OptionsPage optionsPage = new OptionsPage();
                        optionsPage.start(new Stage());
                        // close the menu
                        Stage stage2 = (Stage) this.getScene().getWindow();
                        stage2.close();
                        break;

                    case "Score":
                        // redirect to ScorePage
                        ScorePage scorePage = new ScorePage();
                        scorePage.start(new Stage());
                        // close the menu
                        Stage stage3 = (Stage) this.getScene().getWindow();
                        stage3.close();

                        break;
                    case "Quit":
                        System.exit(0);
                        break;
                }
            });

        }
    }

    public static void main(String[] args) {

        launch(args);
    }


}