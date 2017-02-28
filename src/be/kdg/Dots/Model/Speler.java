package be.kdg.Dots.Model;


/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:56
 */
public class Speler {
    private String naam;
    private int score;

    // naar Dots ??
    // private HashMap<String, Integer> Highscores;

    public Speler() {

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
