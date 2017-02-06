package be.kdg.Dots.Model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:51
 */
public class Lijn {
    private Set<Dot> lijn = new LinkedHashSet<>();
    private int aantalDots;
    private Kleuren color;

    public Lijn() {

    }

    public int getAantalDots() {
        return aantalDots;
    }

    public Kleuren getColor() {
        return color;
    }

    public void setColor(Kleuren color) {
        this.color = color;
    }

    public void addDot(Dot dot) {
        if (lijn.size() == 0) {
            this.color = dot.getColor();
        }
        lijn.add(dot);
    }

    public void removeDot() {

    }

}
