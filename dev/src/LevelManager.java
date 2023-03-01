// The level manager is a singleton class for the level manager (easy, normal, hard), we have the speed / score of the game, and the coefficient of the speed / score

public class LevelManager {

    private static LevelManager instance = null;
    private int speed;
    private int score;
    private int speedCoefficient;
    private int scoreCoefficient;

    private LevelManager() {
        speed = 1;
        score = 0;
        speedCoefficient = 1;
        scoreCoefficient = 1;
    }

    public static LevelManager getInstance() {
        if (instance == null) {
            instance = new LevelManager();
        }
        return instance;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSpeedCoefficient() {
        return speedCoefficient;
    }

    public void setSpeedCoefficient(int speedCoefficient) {
        this.speedCoefficient = speedCoefficient;
    }

    public int getScoreCoefficient() {
        return scoreCoefficient;
    }

    public void setScoreCoefficient(int scoreCoefficient) {
        this.scoreCoefficient = scoreCoefficient;
    }

    public void reset() {
        speed = 1;
        score = 0;
        speedCoefficient = 1;
        scoreCoefficient = 1;
    }

    // easy level
    public void easyLevel() {
        speedCoefficient = 1.1;
        scoreCoefficient = 1.1;
    }

    // normal level
    public void normalLevel() {
        speedCoefficient = 1.3;
        scoreCoefficient = 1.3;
    }


    // hard level
    public void hardLevel() {
        speedCoefficient = 1.5  ;
        scoreCoefficient = 1.5;
    }


}