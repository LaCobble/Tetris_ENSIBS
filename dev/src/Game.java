public class Game {
    private TetrisBoard tetrisBoard;
    private Tetromino currentTetromino;
    private int score;
    private int highScore;
    private boolean isRunning;

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

        }
    }
    
    public void displayHighScore() {
        System.out.println("High Score: " + highScore);
    }


    public void resume(){
        // remove the pause screen and restart the movement
    }

    public void displayCredits(){

    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
