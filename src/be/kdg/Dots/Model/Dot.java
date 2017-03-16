package be.kdg.Dots.Model;

/**
 * Dit is de klasse waarvan de dots op het veld gegenereerd worden.
 *
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:50
 */
public class Dot {
    private Kleuren kleur;
    private int rijIndex;
    private int kolomIndex;
    private int dotNummer;

    /**
     * @param rijIndex De rij-index van de dot op het grid
     * @param kolomIndex De kolom-index van de dot op het grid
     * @param kleur De kleur die word meegegeven aan de dot
     * @param dotNummer De unieke plaatsnummer van de dot op het veld. Deze word verhoogt per nieuwe dot die gegenereerd wordt.
     */
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

    public void setCoordinaten(int rijIndex, int kolomIndex) {
        this.rijIndex = rijIndex;
        this.kolomIndex = kolomIndex;
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
        return o.hashCode() == this.hashCode() ? true : false;
    }

    @Override
    public int hashCode() {
        return kleur.ordinal() ^ dotNummer;
    }
}
