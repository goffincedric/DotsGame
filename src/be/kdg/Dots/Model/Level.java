package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:50
 */

public class Level {
    public static enum Moeilijkheid {
        EASY(30, 50), NORMAL(25, 75), MEDIUM(15, 80), HARD(10, 80), EXTREEM(5, 90);

        private double moeilijkheid;
        private int startScore;

        Moeilijkheid(double moeilijkheid, int startScore) {
            this.moeilijkheid = moeilijkheid;
            this.startScore = startScore;
        }

        public double getMoeilijkheid() {
            return moeilijkheid;
        }

        public int getStartScore() {
            return startScore;
        }
    }

    private int tijd;
    private int targetScore;
    private int gamelevel;
    private Moeilijkheid moeilijkheidsgraad;

    public Level() {
        this.gamelevel = 1;
        this.tijd = 45;
        if (this.moeilijkheidsgraad == null) {
            this.moeilijkheidsgraad = Moeilijkheid.NORMAL;
        }
        this.targetScore = moeilijkheidsgraad.getStartScore();

    }

    public void setMoeilijkheidsgraad(Moeilijkheid moeilijkheidsgraad) {
        this.moeilijkheidsgraad = moeilijkheidsgraad;
        this.targetScore = moeilijkheidsgraad.getStartScore();
    }

    public void setTargetScore(int targetScore) {
        this.targetScore = targetScore;
    }

    public int getTargetScore() {
        return targetScore;
    }

    public int getTijd() {
        return tijd;
    }

    public int getGamelevel() {
        return gamelevel;
    }

    public Moeilijkheid getMoeilijkheidsgraad() {
        return moeilijkheidsgraad;
    }

    public void setGamelevel(int gamelevel) {
        this.gamelevel = gamelevel;
    }

    public void nextLevel() {
        ++gamelevel;
        targetScore = (int) ((Math.round(moeilijkheidsgraad.getStartScore() * Math.pow((double) gamelevel, ((double) gamelevel / getMoeilijkheidsgraad().getMoeilijkheid())))));
        while ((targetScore % 5) != 0) {
            targetScore++;
        }
    }

    @Override
    public String toString() {
        return "Level: " + getGamelevel() + "\t" + "Tijd: " + getTijd() + "\t" + "Targetscore: " + getTargetScore();
    }
}
