package be.kdg.DotsConsole;

import java.util.Random;

/**
 * @author Thomas Verhoeven
 * @version 1.0 6/02/2017 21:32
 */
public class DotConsole{
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

    public boolean isAangrenzend(DotConsole dotConsole2) {
        if (!this.kleur.equals(dotConsole2.getKleur())) {
            return false;
        }
        if ((this.kolomIndex-1 == dotConsole2.getKolomIndex()) || (this.kolomIndex == dotConsole2.getKolomIndex()) || (this.kolomIndex+1 == dotConsole2.getKolomIndex())) {
            if ((this.rijIndex-1 == dotConsole2.getRijIndex()) || (this.rijIndex == dotConsole2.getRijIndex()) || (this.rijIndex+1 == dotConsole2.getRijIndex())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "DotConsole{" +
                "kleur='" + kleur + '\'' +
                ", rijIndex=" + rijIndex +
                ", kolomIndex=" + kolomIndex +
                '}';
    }
}
