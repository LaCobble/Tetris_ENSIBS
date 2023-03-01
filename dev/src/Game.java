import java.util.Scanner;

public class Game {
    private TetrisBoard tetrisBoard;
    private Tetromino currentTetromino;
    private int score;
    private int highScore;
    public boolean isRunning;

    public void start() {
        // Pré-condition: Le jeu n'est pas en cours d'exécution
        if (!isRunning) {
            // Initialiser le plateau de jeu et un Tetromino
            tetrisBoard = new TetrisBoard();
            currentTetromino = Tetromino.getRandomTetromino();
            isRunning = true;
        }
        // Post-condition: Le jeu est maintenant en cours d'exécution
        assert(isRunning);
    }
    
    public void pause() {
        // Pré-condition: Le jeu est en cours d'exécution
        assert(isRunning);
        isRunning = false;
        tetrisBoard.speed = 0;
        // Post-condition: Le jeu n'est plus en cours d'exécution
        assert(!isRunning);
    }
    
    public void end() {
        // Pré-condition: Le jeu est en cours d'exécution
        assert(isRunning);
        isRunning = false;
        // Afficher le score final
        System.out.println("Final Score: " + score);
        // Post-condition: Le jeu n'est plus en cours d'exécution et le score final est affiché
        assert(!isRunning);
    }
    
    public void updateHighScore() {
        if (score > highScore) {
            highScore = score;
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a name");
        String text = scan.nextLine();
        scan.close();

        }
    }
    
    public void displayHighScore() {
        System.out.println("High Score: " + highScore);
    }


    public void resume(){
        // Pré-condition: Le jeu n'est pas en cours d'exécution
        assert(!isRunning);
        isRunning = true;
        tetrisBoard.speed = 1;
        // Post-condition: Le jeu est maintenant en cours d'exécution
        assert(isRunning);
    }

    public void displayCredits(){
        System.out.println("This game was created by this awesome squad:");
        System.out.println("Maucourt Pierre-Yves - Latour Morgan - Saudemont Thomas - Ben Nasrallah Ahmed");
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
