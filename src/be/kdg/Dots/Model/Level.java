package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Level {
    private int tijd; //in seconden
    private int targetScore;
    private double level = 1;

    public Level() {

        this.tijd = 45;
        this.targetScore = (int) (75*(Math.pow((level),(level/21))));

    }

    public int getTargetScore() {
        return (Math.round(targetScore));
    }

    public int getTijd() {
        return tijd;
    }

    public void setTargetScore(int targetScore) {
        this.targetScore = targetScore;
    }

    public double getLevel() {
        return level;
    }


    public void nextLevel(){
        level++;
        setTargetScore((int)(75*(Math.pow((level),(level/21)))));

    }

    @Override
    public String toString() {
        return "Level: " + getLevel() + "\t" + "Tijd: " + getTijd() + "\t" + "Targetscore: " + getTargetScore();
    }
}
