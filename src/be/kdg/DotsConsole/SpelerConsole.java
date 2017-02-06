package be.kdg.DotsConsole;

/**
 * @author Thomas Verhoeven
 * @version 1.0 6/02/2017 21:27
 */
public class SpelerConsole {
    private String naam;

    public SpelerConsole() {

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Speler1: " + this.getNaam();
    }
}
