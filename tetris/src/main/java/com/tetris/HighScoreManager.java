package com.tetris;

import java.io.*;
import java.util.*;

/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used for the high score management. It is used to write the scores in a csv file and to read them to display them in the game.
 *
 */
public class HighScoreManager {

    // the path of the csv file
    private static final String CSV_FILE_PATH = "Files/highscores.csv";

    // the maximum number of scores to be saved
    private static final int MAX_SCORES = 10;

    /**
     * Writes the score of the player in the csv file
     * @param name the name of the player
     * @param score the score of the player
     */
    public static void writeScore(String name, int score) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        lines.add(name + "," + score);
        lines.sort((s1, s2) -> Integer.compare(Integer.parseInt(s2.split(",")[1]), Integer.parseInt(s1.split(",")[1])));
        if (lines.size() > MAX_SCORES) {
            lines = lines.subList(0, MAX_SCORES);
        }
        // write the scores in the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    /**
     * Reads the scores from the csv file
     * @return the list of the scores
     */
    public static List<String> readScores() throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

}
