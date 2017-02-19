package be.kdg.Dots.Model;

import java.util.HashMap;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:56
 */
public class Score extends Dots {

    //list van HighScores (soort van hashmap met speler als key en de Score als value)

    //Score en highscore als attribuut van speler

    private int Score;
    private HashMap<String, Integer> highscores;
    //Deze map moet worden opgeslagen


    public Score() {
        highscores = new HashMap<String, Integer>();
    }

    public int getScore() {
        return Score;
    }

    public void nieuweHighscore() {
        if (!highscores.containsKey(speler.getNaam().toLowerCase())) {
            highscores.put(speler.getNaam().toLowerCase(), super.lijn.bepaalScore());
        }
        if (highscores.get(speler.getNaam().toLowerCase()) < (super.lijn.bepaalScore())) {
            highscores.put(speler.getNaam().toLowerCase(), super.lijn.bepaalScore());
        }

    }
}
