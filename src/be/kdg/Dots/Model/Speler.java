package be.kdg.Dots.Model;


/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:56
 */
public class Speler {
    private String naam;
    private int totaalScore;
    private int gameScore;

    // naar Dots ??
    // private HashMap<String, Integer> Highscores;

    public Speler() {
        this.totaalScore = 0;
        this.gameScore =0;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public Speler(String naam) {
        this.naam = naam;
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

    public void addPuntenTotaalScore(int totaalScore) {
        this.totaalScore = this.totaalScore + totaalScore;
    }

    public void setTotaalScore(int totaalScore) {
        this.totaalScore = totaalScore;
    }

    public void addPunten(int score) {
        this.gameScore = this.gameScore + score;
    }

    @Override
    public String toString() {
        return "Speler 1: " + this.naam;
    }

    //top 10 scores nog wegschrijven naar file

    // vervang Hashmap value naar List van int + verander bijbehorende score
    /*public void nieuweHighscore() {
        if (!Highscores.containsKey(getNaam().toLowerCase())) {
            Highscores.put(getNaam().toLowerCase(), this.score);
        }
        if (Highscores.get(getNaam().toLowerCase()) < this.score) {
            Highscores.put(getNaam().toLowerCase(), this.score);
        }

    }*/
}
