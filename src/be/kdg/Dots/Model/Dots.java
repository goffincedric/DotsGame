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

    }

    public Dots(Speler speler, Level level, Lijn lijn) {
        this.speler = speler;
        this.level = level;
        this.lijn = lijn;
    }


    //Methode maken die een lijn die ingediend wordt vult met nieuwe dots
}

