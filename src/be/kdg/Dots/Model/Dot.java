package be.kdg.Dots.Model;

import javafx.scene.shape.Circle;


import java.util.Random;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Dot extends Dots{
    private Kleuren kleur;
    private int rijIndex; //bepaalt colomindex in array of buttons;
    private int kolomIndex; //bepaalt rijindex in array of buttons;
    private Circle shape;
    //nog niet zeker over die kolom en rijindex

    private static final Kleuren[] VALUES = Kleuren.values();
    private static final int SIZE = VALUES.length;
    private static Random random = new Random();

    public Dot(int kolomIndex, int rijIndex) {
        shape=new Circle();
        this.kolomIndex = kolomIndex;
        this.rijIndex = rijIndex;
        this.kleur = getRandomKleur();


    }

    public static Kleuren getRandomKleur(){
        return VALUES[random.nextInt(SIZE)];
    }

    public Kleuren getColor() {
        return kleur;
    }

    public int getKolomIndex() {
        return kolomIndex;
    }

    public int getRijIndex() {
        return rijIndex;
    }

    public boolean isAangrenzend(Dot dot2) {
        if (!this.kleur.name().equals(dot2.getColor().name())) {
            return false;
        }
        if ((this.kolomIndex-1 == dot2.getKolomIndex()) || (this.kolomIndex == dot2.getKolomIndex()) || (this.kolomIndex+1 == dot2.getKolomIndex())) {
            if ((this.rijIndex-1 == dot2.getRijIndex()) || (this.rijIndex == dot2.getRijIndex()) || (this.rijIndex+1 == dot2.getRijIndex())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "kleur=" + kleur +
                ", rijIndex=" + rijIndex +
                ", kolomIndex=" + kolomIndex +
                '}';
    }
}
