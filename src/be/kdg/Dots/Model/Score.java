package be.kdg.Dots.Model;

import java.util.HashMap;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:56
 */
public class Score extends Dots {



    private int Score; //via getters krijgen in presenter
    private String Naam;
    private int Level;


    public Score(String naam, int Score, int Level) {

    }

    public int getScore() {
        return Score;
    }

    public void nieuweHighscore() {
        if (!highscores.containsKey(speler.getNaam().toLowerCase())) {
            highscores.put(speler.getNaam().toLowerCase(), super.lijn.getAantalDots());
        }
        if (highscores.get(speler.getNaam().toLowerCase()) < (super.lijn.getAantalDots())) {
            highscores.put(speler.getNaam().toLowerCase(), super.lijn.getAantalDots());
        }
    }
}
