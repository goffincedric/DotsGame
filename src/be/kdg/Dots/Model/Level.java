package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Level {
    private int tijd; //in seconden
    private int targetScore;
    private int level = 1;

    public Level() {
        this.tijd = 45;
        this.targetScore = 75;
    }

    public int getTargetScore() {
        return targetScore;
    }

    public int getTijd() {
        return tijd;
    }

    public int getLevel() {
        return level;
    }


    public void nextLevel(){
        ++level;
        targetScore = (int)Math.round(75*Math.pow((double)level, ((double)level / 18)));
        while ((targetScore%5) != 0) {
            targetScore++;
        }
    }

    @Override
    public String toString() {
        return "Level: " + getLevel() + "\t" + "Tijd: " + getTijd() + "\t" + "Targetscore: " + getTargetScore();
    }
}
