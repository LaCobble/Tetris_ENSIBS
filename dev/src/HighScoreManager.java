import java.io.*;
import java.util.*;

public class HighScoreManager {
    private static final String CSV_FILE_PATH = "highscores.csv";
    private static final int MAX_HIGHSCORES = 3;

    // Get the best score with the given nickname
    public static int getBestScore(String nickname) {
        int bestScore = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[0].equals(nickname)) {
                    int score = Integer.parseInt(fields[1]);
                    if (score > bestScore) {
                        bestScore = score;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return bestScore;
    }

    // Write a score and its nickname to the document
    public static void writeScore(String nickname, int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.write(nickname + "," + score + "\n");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Get the top N scores with their nicknames
    public static Map<String, Integer> getTopScores(int n) {
        Map<String, Integer> topScores = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                String nickname = fields[0];
                int score = Integer.parseInt(fields[1]);
                if (topScores.size() < n) {
                    topScores.put(nickname, score);
                } else {
                    for (Map.Entry<String, Integer> entry : topScores.entrySet()) {
                        if (score > entry.getValue()) {
                            topScores.remove(entry.getKey());
                            topScores.put(nickname, score);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return topScores;
    }

    public static void main(String[] args) {
        // Example usage
        writeScore("Alice", 100);
        writeScore("Bob", 200);
        writeScore("Charlie", 300);
        writeScore("David", 400);

        int bestScore = getBestScore("Charlie");
        System.out.println("Best score for Charlie: " + bestScore);

        Map<String, Integer> topScores = getTopScores(MAX_HIGHSCORES);
        System.out.println("Top " + MAX_HIGHSCORES + " scores:");
        for (Map.Entry<String, Integer> entry : topScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
