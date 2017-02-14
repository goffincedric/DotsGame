package be.kdg.Dots.Model;

import java.util.HashMap;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:56
 */
public class Score extends Dots {

    //list van HighScores (soort van hashmap met speler als key en de Score als value)

    private Integer Score;
    private HashMap<String, Integer> Highscores;
    //Deze map moet worden opgeslagen


    public Score() {
        Highscores = new HashMap<String, Integer>();
    }

    public Integer getScore() {
        return Score;
    }

    public void nieuweHighscore() {
        if (!Highscores.containsKey(speler.getNaam().toLowerCase())) {
            Highscores.put(speler.getNaam().toLowerCase(), super.lijn.bepaalScore());
        }
        if (Highscores.get(speler.getNaam().toLowerCase()) < (super.lijn.bepaalScore())) {
            Highscores.put(speler.getNaam().toLowerCase(), super.lijn.bepaalScore());
        }

    }
}
