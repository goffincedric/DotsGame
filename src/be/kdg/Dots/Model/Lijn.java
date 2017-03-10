package be.kdg.Dots.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:51
 */

public class Lijn {
    private List<Dot> lijn;
    private int aantalDots;
    private Kleuren kleur;
    private boolean heeftToegevoegd;

    public Lijn() {
        lijn = new ArrayList<>();
        this.aantalDots = 0;
        this.heeftToegevoegd = false;
    }

    public List<Dot> getLijn() {
        return lijn;
    }

    public int getAantalDots() {
        return aantalDots;
    }

    public Kleuren getKleur() {
        return kleur;
    }

    public void setKleur(Kleuren kleur) {
        this.kleur = kleur;
    }

    public Dot[] getLijnDotArray() {
        Dot[] dotArray = new Dot[lijn.size()];
        return lijn.toArray(dotArray);
    }

    public boolean getHeeftToegevoegd() {
        return heeftToegevoegd;
    }


    public void addDot(Dot nieuweDot) throws DotsException {
        if (lijn.isEmpty()) {
            lijn.add(0, nieuweDot);
            aantalDots++;
            heeftToegevoegd = true;
        } else {

            Dot laatsteDot = getLaatsteDot();
            if (nieuweDot.equals(laatsteDot)) {
                lijn.remove(lijn.size() - 1);
                aantalDots--;
                heeftToegevoegd = false;
                throw new DotsException("Vorige dot verwijderd");
            }

            for (Dot dot : lijn) {
                if ((dot.getRijIndex() == nieuweDot.getRijIndex()) && (dot.getKolomIndex() == nieuweDot.getKolomIndex())) {
                    throw new DotsException("Gekozen bol is al gebruikt in lijn.");
                }
            }

            if (laatsteDot.getKleur().equals(nieuweDot.getKleur())) {
                if ((laatsteDot.getKolomIndex() - 1 == nieuweDot.getKolomIndex()) || (laatsteDot.getKolomIndex() == nieuweDot.getKolomIndex()) ||
                        (lijn.get(lijn.size() - 1).getKolomIndex() + 1 == nieuweDot.getKolomIndex())) {
                    if ((laatsteDot.getRijIndex() - 1 == nieuweDot.getRijIndex()) || (laatsteDot.getRijIndex() == nieuweDot.getRijIndex()) ||
                            (laatsteDot.getRijIndex() + 1 == nieuweDot.getRijIndex())) {
                        lijn.add(lijn.size(), nieuweDot);
                        aantalDots++;
                        heeftToegevoegd = true;
                    } else {
                        heeftToegevoegd = false;
                        throw new DotsException("Bollen liggen niet naast elkaar; Dot 1: (" + laatsteDot.getKolomIndex() + ", " + laatsteDot.getRijIndex() + "); Dot 2: (" +
                                nieuweDot.getKolomIndex() + ", " + nieuweDot.getRijIndex() + ")\nBol niet toegevoegd.");
                    }
                } else {
                    heeftToegevoegd = false;
                    throw new DotsException("Bollen liggen niet naast elkaar; Dot 1: (" + laatsteDot.getKolomIndex() + ", " + laatsteDot.getRijIndex() + "); Dot 2: (" +
                            nieuweDot.getKolomIndex() + ", " + nieuweDot.getRijIndex() + ")\nBol niet toegevoegd.");
                }
            } else {
                heeftToegevoegd = false;
                throw new DotsException("Bollen hebben niet dezelfde kleur; Dot 1: " + laatsteDot.getKleur().name() + "; Dot 2: " + nieuweDot.getKleur().name() + "\nBol niet toegevoegd.");
            }
        }
    }

    public Dot getDot(int rij, int kolom) {
        for (Dot dot : lijn) {
            if (dot.getRijIndex() == rij && dot.getKolomIndex() == kolom) {
                return dot;
            }
        }
        return null;
    }

    public Dot getLaatsteDot() {
        return lijn.get(lijn.size() - 1);
    }

    public void removeDot(Dot dot) {
        if (dot.equals(lijn.get(lijn.size() - 1))) ;
        {
            lijn.remove(lijn.size() - 1);
        }
    }

    public String printList() {
        String lijnString = "";
        for (Dot dot : lijn) {
            lijnString += "Kleur: " + dot.getKleur() + "\nIndex [Kolom|Rij]: (" + dot.getKolomIndex() + ", " + dot.getRijIndex() + ")\n";
        }
        return lijnString;
    }
}
