package be.kdg.Dots.Model;

import javafx.scene.shape.Circle;

import java.awt.*;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Dot {
    private Kleuren kleur;
    private int rijIndex; //bepaalt colomindex in array of buttons;
    private int kolomIndex; //bepaalt rijindex in array of buttons;
    private Circle shape;
    //nog niet zeker over die kolom en rijindex


    public Dot(int kolomIndex, int rijIndex, Kleuren kleur) {
        shape=new Circle();
        this.kolomIndex = kolomIndex;
        this.rijIndex = rijIndex;

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
}
