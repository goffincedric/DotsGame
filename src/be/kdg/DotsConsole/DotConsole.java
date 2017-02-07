package be.kdg.DotsConsole;

import java.util.Random;

/**
 * @author Thomas Verhoeven
 * @version 1.0 6/02/2017 21:32
 */
public class DotConsole {
    private String kleur;
    private int rijIndex;
    private int kolomIndex;
    Random r = new Random();
    private String kleuren[]={"G","B","P","R"};



    public DotConsole(int rijIndex, int kolomIndex) {
        this.kleur = kleuren[r.nextInt(4)].toString();
        this.rijIndex = rijIndex;
        this.kolomIndex = kolomIndex;
    }

    public String getKleur() {
        return kleur;
    }

    public int getRijIndex() {
        return rijIndex;
    }

    public int getKolomIndex() {
        return kolomIndex;
    }
}
