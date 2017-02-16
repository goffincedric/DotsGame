package be.kdg.DotsConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Verhoeven
 * @version 1.0 6/02/2017 22:01
 */
public class LijnConsole {

    //vraag user naar kolom en rij
    //blijf dit doen in een loop
    //vergelijk steeds de  dots

    private List<DotConsole> lijn;
    private int aantalDots;
    private String lijnKleur;


    public LijnConsole() {
        lijn = new ArrayList<>();
        this.aantalDots = 0;
    }

    public List<DotConsole> getLijn() {
        return lijn;
    }

    public DotConsole[] getLijnDotArray () {
        DotConsole[] dotConsoleArray = new DotConsole[lijn.size()];

        for (int i = 0; i < lijn.size(); i++) {
            DotConsole dotConsole = lijn.get(i);
            dotConsoleArray[i] = dotConsole;
        }

        return dotConsoleArray;
    }

    public void addDot(DotConsole nieuweDot) throws DotsConsoleException {
        if (lijn.isEmpty()) {
            lijn.add(0, nieuweDot);
        } else {
            for (DotConsole dot : lijn) {
                if ((dot.getRijIndex() == nieuweDot.getRijIndex()) && (dot.getKolomIndex() == nieuweDot.getKolomIndex())) {
                    throw new DotsConsoleException("Gekozen bol is al gebruikt in lijn.");
                }
            }

            DotConsole laatsteDot = getLaatsteDot();
            if (laatsteDot.getKleur().equals(nieuweDot.getKleur())) {
                if ((laatsteDot.getKolomIndex() - 1 == nieuweDot.getKolomIndex()) || (laatsteDot.getKolomIndex() == nieuweDot.getKolomIndex()) ||
                        (lijn.get(lijn.size() - 1).getKolomIndex() + 1 == nieuweDot.getKolomIndex())) {
                    if ((laatsteDot.getRijIndex() - 1 == nieuweDot.getRijIndex()) || (laatsteDot.getRijIndex() == nieuweDot.getRijIndex()) ||
                            (laatsteDot.getRijIndex() + 1 == nieuweDot.getRijIndex())) {
                        lijn.add(lijn.size(), nieuweDot);
                    } else {
                        System.out.println("Bollen liggen niet naast elkaar; Dot 1: (" + laatsteDot.getKolomIndex() + ", " + laatsteDot.getRijIndex() + "); Dot 2: (" +
                                nieuweDot.getKolomIndex() + ", " + nieuweDot.getRijIndex() + ")\nBol niet toegevoegd.");
                    }
                } else {
                    System.out.println("Bollen liggen niet naast elkaar; Dot 1: (" + laatsteDot.getKolomIndex() + ", " + laatsteDot.getRijIndex() + "); Dot 2: (" +
                            nieuweDot.getKolomIndex() + ", " + nieuweDot.getRijIndex() + ")\nBol niet toegevoegd.");
                }
            } else {
                System.out.println("Bollen hebben niet dezelfde kleur; Dot 1: " + laatsteDot.getKleur() + "; Dot 2: " + nieuweDot.getKleur() + "\nBol niet toegevoegd.");
            }
        }
    }

    public DotConsole getLaatsteDot() {
        return lijn.get(lijn.size() - 1);
    }

    public String printList() {
        for (DotConsole dotConsole : lijn) {
            return String.format("Kleur: " + dotConsole.getKleur() + "\nIndex [Kolom|Rij]: " + dotConsole.getKolomIndex()) + dotConsole.getRijIndex();
        }
        return "";
    }
}
