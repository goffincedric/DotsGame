package be.kdg.Dots.Model;

import java.util.HashMap;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:56
 */
public class Speler {
    private String naam;
    private int highScore;
    private HashMap<String, Integer> Highscores;
    private int score;

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


    public int getHighScore() {
        return highScore;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void nieuweHighscore() {
        if (!Highscores.containsKey(getNaam().toLowerCase())) {
            Highscores.put(getNaam().toLowerCase(), super.lijn.bepaalScore());
        }
        if (Highscores.get(getNaam().toLowerCase()) < (super.lijn.bepaalScore())) {
            Highscores.put(getNaam().toLowerCase(), super.lijn.bepaalScore());
        }

    }
}
