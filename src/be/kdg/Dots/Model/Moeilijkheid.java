package be.kdg.Dots.Model;

/**
 * @author Thomas Verhoeven
 * @version 1.0 8/02/2017 14:22
 */
public enum Moeilijkheid {
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
