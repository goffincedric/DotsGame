package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:32
 */
public class Dots {
    private int gehaaldeScore;
    Speler speler;
    Level level;
    Lijn lijn;


    public Dots(){
        speler = new Speler();
        level = new Level();
        lijn = new Lijn();
        this.gehaaldeScore = 0;
    }


    public int getGehaaldeScore() {
        return lijn.bepaalScore();
    }

}

