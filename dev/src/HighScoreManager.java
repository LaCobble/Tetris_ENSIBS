import java.io.*;
import java.util.*;

// a csv file with the 10 best scores and the name of the player, write the score if it is in the top 10, and read the scores from the file to display them in the game
public class HighScoreManager {

    // csv path file
    private static final String CSV_FILE_PATH = "Files/highscores.csv";

    // the maximum number of scores to be saved
    private static final int MAX_SCORES = 10;

    // a csv file with the 10 best scores and the name of the player
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // read the scores from the file to display them in the game
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
