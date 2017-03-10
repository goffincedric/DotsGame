package be.kdg.Dots.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:32
 */
public class Dots {

    private final int MAXRIJ = 7;
    private final int MAXKOLOM = 7;
    private Dot[][] speelveld;
    private static final Kleuren KLEUREN[] = Kleuren.values();
    private static int aantalKleuren;
    private int plaatsNummer;
    private List<Kleuren> dotKleuren;
    private static Random random;

    private static final int START_TICK_DURATION_MILLIS = 1000;
    private int seconds;
    private int tickDurationMillis;

    Speler speler;
    Level level;
    Lijn lijn;


    public Dots() {
        this.speler = new Speler();
        this.level = new Level();
        this.lijn = new Lijn();
        this.speelveld = new Dot[MAXRIJ][MAXKOLOM];
        this.aantalKleuren = 4;
        this.plaatsNummer = 0;
        dotKleuren = new ArrayList<>();
        this.random = new Random();

        this.tickDurationMillis = START_TICK_DURATION_MILLIS;
        this.seconds = 45;

        for (int i = 0; i < aantalKleuren; i++) {
            Kleuren kleur;
            do {
                 kleur = KLEUREN[random.nextInt(KLEUREN.length)];
            } while (dotKleuren.contains(kleur));
            dotKleuren.add(kleur);
        }

        for (int rij = 0; rij < MAXRIJ; rij++) {
            for (int kolom = 0; kolom < MAXKOLOM; kolom++) {
                speelveld[rij][kolom] = new Dot(rij, kolom, dotKleuren.get(random.nextInt(dotKleuren.size())), plaatsNummer);
                plaatsNummer++;
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

    public int getPlaatsNummer() {
        return plaatsNummer;
    }

    public void verhoogPlaatsnummer() {
        plaatsNummer++;
    }

    public Dot[][] getSpeelveld() {
        return speelveld;
    }

    public Dot getDotUitSpeelveld(int rij, int kolom) {
        return speelveld[rij][kolom];
    }

    public void vervangGebruikteDots() {
        Dot[] gebruikteDots = lijn.getLijnDotArray();

        for (Dot dot : gebruikteDots) {
            this.speelveld[dot.getRijIndex()][dot.getKolomIndex()] = null;
        }

        int rijTeller;

        for (int i = MAXRIJ -1; i >= 0; i--) {
            for (int j = MAXKOLOM -1; j >= 0 ; j--) {
                if (speelveld[i][j] == null) {
                    rijTeller = i;
                    do {
                        rijTeller--;
                    } while ((rijTeller == -1)?false:(speelveld[rijTeller][j] == null) && rijTeller > -1);

                    switch (rijTeller) {
                        case -1:
                            for (int k = 0; k <= i; k++) {
                                speelveld[k][j] = new Dot(k, j, dotKleuren.get(random.nextInt(dotKleuren.size())), plaatsNummer);
                                plaatsNummer++;
                            }
                            break;
                        default:
                            speelveld[i][j] = speelveld[rijTeller][j];
                            speelveld[rijTeller][j] = null;
                            break;
                    }
                }
            }
        }

        for (int i = MAXRIJ-1; i >= 0; i--) {
            for (int j = MAXKOLOM-1; j >=0; j--) {
                speelveld[i][j].setCoordinaten(i, j);
            }
        }
    }

    public void maakLijnLeeg () {
        lijn = new Lijn();
    }

    public void resetSpel() {
        this.lijn = new Lijn();
        this.speelveld = new Dot[MAXRIJ][MAXKOLOM];

        dotKleuren = new ArrayList<>();

        this.plaatsNummer = 0;
        this.tickDurationMillis = START_TICK_DURATION_MILLIS;
        this.seconds = 45;

        for (int i = 0; i < aantalKleuren; i++) {
            Kleuren kleur;
            do {
                kleur = KLEUREN[random.nextInt(KLEUREN.length)];
            } while (dotKleuren.contains(kleur));
            dotKleuren.add(kleur);
        }

        for (int rij = 0; rij < MAXRIJ; rij++) {
            for (int kolom = 0; kolom < MAXKOLOM; kolom++) {
                speelveld[rij][kolom] = new Dot(rij, kolom, dotKleuren.get(random.nextInt(dotKleuren.size())), plaatsNummer);
                plaatsNummer++;
            }
        }
    }

    public void tick() {
        this.seconds--;
    }

    public int getSeconds() {
        return seconds;
    }

    public void resetTimer() {
        this.seconds = 45;
        this.tickDurationMillis -= 100;
    }

    public int getTickDurationMillis() {
        return tickDurationMillis;
    }
}