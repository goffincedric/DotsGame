package be.kdg.Dots.Model;

import java.awt.*;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public enum Kleuren {
    Grijs(new Color(229, 17, 73)), Wit(new Color(226, 7, 100)), Roos(new Color(360, 52, 100)), Rood(new Color(251, 67, 7)), Oranje(new Color(251, 117, 7)), Geel(new Color(251, 210, 7)),
    Groen(new Color(100, 92, 66)), LichtGroen(new Color(100, 92, 82)), Cyaan(new Color(12, 211, 210)), LichtBlauw(new Color(83, 166, 214)), Blauw(new Color(0, 135, 214)),
    Paars(new Color(280, 71, 98)), Beige(new Color(46, 37, 76)), Bruin(new Color(12, 69, 40));

    private Color color;

    Kleuren(Color color) {
        this.color = color;
    }

    public Color getKleur() {
        return color;
    }

    @Override
    public String toString() {
        return "Kleuren{" +
                "color=" + color +
                '}';
    }
}
