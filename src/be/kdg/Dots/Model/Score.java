package be.kdg.Dots.Model;

import java.util.HashMap;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:56
 */
public class Score {

    //list van HighScores (soort van hashmap met speler als key en de Score als value)

    private Integer Score;
    private HashMap<Speler, Integer> Highscores = new HashMap<Speler,Integer>();



}
