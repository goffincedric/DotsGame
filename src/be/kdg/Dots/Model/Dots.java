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
    private final int MAXRIJ = 7;
    private final int MAXKOLOM = 7;
    private Dot[][] speelveld;

    public Dots(){
        speler = new Speler();
        level = new Level();
        lijn = new Lijn();
        this.gehaaldeScore = 0;

        speelveld = new Dot[MAXRIJ][MAXKOLOM];
        for (int rij = 0; rij < MAXRIJ; rij++) {
            for (int kolom = 0; kolom < MAXKOLOM; kolom++) {
                speelveld[rij][kolom] = new Dot(rij, kolom);
            }
        }
    }


    ///Waarom score weten in deze klasse??
    // dat kan ook in speler gezet worden indien nodig, maar dan moet dat opgehaald worden met super.lijn.bepaalScore();

    public int getGehaaldeScore() {
        return lijn.bepaalScore();
    }


    //Methode maken die een lijn die ingediend wordt vult met nieuwe dots
}

