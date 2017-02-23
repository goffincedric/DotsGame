package be.kdg.Dots.Model;

import java.util.Scanner;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:32
 */
public class Dots {
    private int gehaaldeScore;
    private final int MAXRIJ = 7;
    private final int MAXKOLOM = 7;
    private Dot[][] speelveld;

    Speler speler;
    Level level;
    Lijn lijn;

    public Dots() {
        this.speler =  new Speler();
        this.level = new Level();
        this.lijn = new Lijn();
        this.speelveld = new Dot[MAXRIJ][MAXKOLOM];

        for (int rij = 0; rij < MAXRIJ; rij++) {
            for (int kolom = 0; kolom < MAXKOLOM; kolom++) {
                speelveld[rij][kolom] = new Dot(rij, kolom);
            }
        }
    }

    public Speler getSpeler() {
        return speler;
    }

    public Level getLevel() {
        return level;
    }

    public Lijn getLijn() {
        return lijn;
    }

    public Dot[][] getSpeelveld() {
        return speelveld;
    }

    public Dot getDotUitSpeelveld(int rij, int kolom) {
        return speelveld[rij][kolom];
    }
}