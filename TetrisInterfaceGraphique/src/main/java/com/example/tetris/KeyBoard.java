import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used for the keyboard management.
 *
 */
public class KeyBoard {

    /**
     * This method is used to read the keyboard.
     * @return the input
     * @throws IOException
     */
    public static String read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        return input;
    }

    /**
     * This method is used to read the direction.
     * @return the direction
     * @throws IOException
     */
    public static String readDirection() throws IOException {
        String input = read();
        if (input.equals("z") || input.equals("Z")) {
            return "up";
        } else if (input.equals("s") || input.equals("S")) {
            return "down";
        } else if (input.equals("q") || input.equals("Q")) {
            return "left";
        } else if (input.equals("d") || input.equals("D")) {
            return "right";
        } else {
            return "wrong";
        }
    }
}