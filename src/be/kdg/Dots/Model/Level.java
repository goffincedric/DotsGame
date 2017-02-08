package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Level extends Dots {
    private int tijd; //in seconden
    private int targetScore;
    private int level = 1;
    private Moeilijkheid moeilijkheidsgraad;

    public Level() {
        this.tijd = 45;
        this.moeilijkheidsgraad = Moeilijkheid.EASY;
        this.targetScore = moeilijkheidsgraad.getStartScore();

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

    public Moeilijkheid getMoeilijkheidsgraad() {
        return moeilijkheidsgraad;
    }

    public void nextLevel(){
        ++level;
        targetScore = (int)((Math.round(moeilijkheidsgraad.getStartScore()*Math.pow((double)level, ((double)level / getMoeilijkheidsgraad().getMoeilijkheid())))));
        while ((targetScore%5) != 0) {
            targetScore++;
        }
    }

    @Override
    public String toString() {
        return "Level: " + getLevel() + "\t" + "Tijd: " + getTijd() + "\t" + "Targetscore: " + getTargetScore();
    }
}
