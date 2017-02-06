package be.kdg.Dots.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:51
 */
public class Lijn {
    private List<Dot> lijn = new ArrayList<>();
    private int aantalDots;
    private Kleuren color;

    public Lijn() {

    }

    public void setColor(Kleuren color) {
        this.color = color;
    }
}
