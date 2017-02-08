package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Level {
    private int tijd; //in seconden
    private double targetScore;
    private int level = 1;

    public Level() {

        this.tijd = 45;
        this.targetScore = Math.pow((75 * level),(level/21));

    }

    public double getTargetScore() {
        return targetScore;
    }

    public int getTijd() {
        return tijd;
    }

    public void setTargetScore(double targetScore) {
        this.targetScore = targetScore;
    }

    public int getLevel() {
        return level;
    }


    public void nextLevel(){
        level++;
        setTargetScore(Math.pow((75 * level),(level/21)));

    }

    @Override
    public String toString() {
        return "Level: " + getLevel() + "\t" + "Tijd: " + getTijd() + "\t" + "Targetscore: " + getTargetScore();
    }
}
