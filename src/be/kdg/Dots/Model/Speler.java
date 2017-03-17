package be.kdg.Dots.Model;


/**
 * Dit is de klasse waarvan speleropbjecten gecreëerd worden.
 *
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:56
 */

public class Speler {
    private String naam;
    private int totaalScore;
    private int gameScore;
    private static final String HIGHSCORE_FILE = "Files/HighScores.txt";

    public Speler() {
        this.totaalScore = 0;
        this.gameScore = 0;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getTotaalScore() {
        return totaalScore;
    }

    /**
     * Deze methode voegt de apart scores per level toe aan de totale score.
     *
     * @param totaalScore De score die toegevoegd moet worden aan de totale score
     */
    public void addPuntenTotaalScore(int totaalScore) {
        this.totaalScore = this.totaalScore + totaalScore;
    }

    @Override
    public String toString() {
        return "Speler 1: " + this.naam;
    }


}
