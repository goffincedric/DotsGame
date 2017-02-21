package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:32
 */
public class Dots {
    private int gehaaldeScore;
    private final int MAXRIJ = 7;
    private final int MAXKOLOM = 7;
    private Dot[][] speelveld = new Dot[MAXRIJ][MAXKOLOM];

    Speler speler;
    Level level;
    Lijn lijn;

    public Dots() {
        this.speler =  new Speler();
        this.level = new Level();
        this.lijn = new Lijn();
    }
}

