import java.util.Scanner;
/**
 *
 * @author Cyberlog - Groupe 2
 * @version 1.0
 * This class is used for managing the game. It is used to start, pause, resume, end the game.
 *
 */
public class Game {

    // Attributes
    // The TetrisBoard object
    private TetrisBoard tetrisBoard;

    // The current Tetromino
    private Tetromino currentTetromino;

    // The score
    private int score;

    // The high score
    private int highScore;

    // The game is running
    private boolean isRunning;

    /**
     * Allows to start the game
     */
    public void start() {
        // Pré-condition: Le jeu n'est pas en cours d'exécution
        if (!isRunning) {
            // Initialiser le plateau de jeu et un Tetromino
            tetrisBoard = new TetrisBoard();
            //currentTetromino = TetrisBoard.addTetris();
            isRunning = true;
        }
        // Post-condition: Le jeu est maintenant en cours d'exécution
        assert(isRunning);
    }

    /**
     * Allows to pause the game
     */
    public void pause() {
        // Pré-condition: Le jeu est en cours d'exécution
        assert(isRunning);
        isRunning = false;
        tetrisBoard.setSpeed(0);
        // Post-condition: Le jeu n'est plus en cours d'exécution
        assert(!isRunning);
    }

    /**
     * Allows to end the game
     */
    public void end() {
        // Pré-condition: Le jeu est en cours d'exécution
        assert(isRunning);
        isRunning = false;
        // Afficher le score final
        System.out.println("Final Score: " + score);
        // Post-condition: Le jeu n'est plus en cours d'exécution et le score final est affiché
        assert(!isRunning);
    }

    /**
     * Allows to update the high score
     */
    public void updateHighScore() {
        if (score > highScore) {
            highScore = score;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a name");
        String text = scan.nextLine();
        scan.close();

        }
    }

    /**
     * Allows to display the high score
     */
    public void displayHighScore() {
        System.out.println("High Score: " + highScore);
    }

    /**
     * Allows to resume the game
     */
    public void resume(){
        // Pré-condition: Le jeu n'est pas en cours d'exécution
        assert(!isRunning);
        isRunning = true;
        tetrisBoard.setSpeed(1);
        // Post-condition: Le jeu est maintenant en cours d'exécution
        assert(isRunning);
    }

    /**
     * Allows to display the credits
     */
    public void displayCredits(){
        System.out.println("This game was created by this awesome squad:");
        System.out.println("Maucourt Pierre-Yves - Latour Morgan - Saudemont Thomas - Ben Nasrallah Ahmed");
    }

    /**
     * Allows to display the game rules
     * @param score integer
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Getter of the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Test if the game is running
     */
    public Boolean getisRunning() {
        return isRunning;
    }

    /**
     * Setter of the game state
     */
    public void setisRunning(Boolean bool){
        this.isRunning = bool;
    }
}
