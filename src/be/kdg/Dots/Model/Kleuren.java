package be.kdg.Dots.Model;

import javafx.scene.paint.Color;

/**
 * Deze enum bevat alle kleuren die gebruikt kunnen worden in het spel.
 * Elke kleur bevat een hard-coded rgb waarde die gebruikt wordt in de klasse SpelView om de dots op het veld een kleur te geven.
 *
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:50
 */
public enum Kleuren {
    Grijs(Color.rgb(154, 160, 186)),
    Donkergrijs(Color.rgb(73, 88, 103)),
    Roos(Color.rgb(255, 122, 122)),
    Rood(Color.rgb(251, 67, 7)),
    Oranje(Color.rgb(251, 117, 7)),
    Geel(Color.rgb(251, 210, 7)),
    Groen(Color.rgb(52, 135, 10)),
    Lichtgroen(Color.rgb(86, 191, 34)),
    Cyaan(Color.rgb(12, 211, 210)),
    Lichtblauw(Color.rgb(83, 166, 214)),
    Blauw(Color.rgb(0, 135, 214)),
    Paars(Color.rgb(190, 72, 249)),
    Beige(Color.rgb(193, 177, 122)),
    Bruin(Color.rgb(135, 60, 41));

    private Color color;

    Kleuren(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getRed() {
        return (int) Math.round(this.getColor().getRed() * 255);
    }

    public int getGreen() {
        return (int) Math.round(this.getColor().getGreen() * 255);
    }

    public int getBlue() {
        return (int) Math.round(this.getColor().getBlue() * 255);
    }

    @Override
    public String toString() {
        return "Kleuren{" +
                "color=" + color +
                '}';
    }
}
