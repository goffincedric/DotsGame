package be.kdg.Dots.Model;

import javafx.scene.shape.Circle;

import java.awt.*;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Dot {
    private Kleuren color;
    private int rijIndex; //bepaalt colomindex in array of buttons;
    private int kolomIndex; //bepaalt rijindex in array of buttons;
    private Circle shape;
    //nog niet zeker over die kolom en rijindex


    public Dot() {
        shape=new Circle();
        //rijindex en kolomindex in array bepalen
        ///color bepalen random


    }

    public Kleuren getColor() {
        return color;
    }
}
