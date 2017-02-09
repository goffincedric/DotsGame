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


    public Dots() {
        this.gehaaldeScore = 0;
        for (int rij = 0; rij < MAXRIJ; rij++) {
            for (int kolom = 0; kolom < MAXKOLOM; kolom++) {
                speelveld[rij][kolom] = new Dot(rij, kolom);
            }
        }
    }


    //Methode maken die een lijn die ingediend wordt vult met nieuwe dots
}

