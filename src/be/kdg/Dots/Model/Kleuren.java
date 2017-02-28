package be.kdg.Dots.Model;

import javafx.scene.paint.Color;
import java.util.Random;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */

public enum Kleuren {
    Grijs(Color.rgb(229, 17, 73)),
    Wit(Color.rgb(226, 7, 100)),
    Roos(Color.rgb(255, 122, 122)),
    Rood(Color.rgb(251, 67, 7)),
    Oranje(Color.rgb(251, 117, 7)),
    Geel(Color.rgb(251, 210, 7)),
    Groen(Color.rgb(100, 92, 66)),
    LichtGroen(Color.rgb(100, 92, 82)),
    Cyaan(Color.rgb(12, 211, 210)),
    LichtBlauw(Color.rgb(83, 166, 214)),
    Blauw(Color.rgb(0, 135, 214)),
    Paars(Color.rgb(190, 72, 249)),
    Beige(Color.rgb(46, 37, 76)),
    Bruin(Color.rgb(12, 69, 40));

    private Color color;
    private Random random = new Random();

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
