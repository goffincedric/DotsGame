package be.kdg.DotsConsole;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 6/02/2017 21:27
 */
public class SpelerConsole {
    private String naam;
    private int score;

    public SpelerConsole() {

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Speler1: " + this.getNaam();
    }
}
