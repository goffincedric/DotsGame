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
    private int dotNummer;

    public Dot(int rijIndex, int kolomIndex, Kleuren kleur, int dotNummer) {
        this.kleur = kleur;
        this.kolomIndex = kolomIndex;
        this.rijIndex = rijIndex;
        this.dotNummer = dotNummer;
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
        return kleur.ordinal() ^ rijIndex ^ kolomIndex ^ dotNummer;
    }
}
