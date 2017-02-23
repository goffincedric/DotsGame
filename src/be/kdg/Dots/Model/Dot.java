package be.kdg.Dots.Model;

import javafx.scene.shape.Circle;


import java.util.Random;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Dot {
    private Kleuren kleur;
    private int rijIndex;
    private int kolomIndex;

    public Dot(int rijIndex, int kolomIndex, Kleuren kleur) {
        this.kleur = kleur;
        this.kolomIndex = kolomIndex;
        this.rijIndex = rijIndex;
    }

    public Kleuren getKleur() {
        return kleur;
    }

    public int getRijIndex() {
        return rijIndex;
    }

    public int getKolomIndex() {
        return kolomIndex;
    }

    /*public boolean isAangrenzend(Dot dot2) {
        if (!this.kleur.name().equals(dot2.getKleur().name())) {
            return false;
        }
        if ((this.kolomIndex - 1 == dot2.getKolomIndex()) || (this.kolomIndex == dot2.getKolomIndex()) || (this.kolomIndex + 1 == dot2.getKolomIndex())) {
            if ((this.rijIndex - 1 == dot2.getRijIndex()) || (this.rijIndex == dot2.getRijIndex()) || (this.rijIndex + 1 == dot2.getRijIndex())) {
                return true;
            }
        }
        return false;
    }*/

    @Override
    public String toString() {
        return "Dot{" +
                "kleur=" + kleur +
                ", rijIndex=" + rijIndex +
                ", kolomIndex=" + kolomIndex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return o.hashCode()== this.hashCode()?true:false;
    }

    @Override
    public int hashCode() {
        return kleur.ordinal() ^ rijIndex ^ kolomIndex;
    }
}
