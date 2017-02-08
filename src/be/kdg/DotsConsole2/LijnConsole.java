package be.kdg.DotsConsole2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Verhoeven
 * @version 1.0 6/02/2017 22:01
 */
public class LijnConsole extends DotsConsole {

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

    public void addDot(DotConsole nieuweDot) {
        if (lijn.isEmpty()) {
            lijn.add(0,nieuweDot);
        } else {
            DotConsole laatsteDot = getLaatsteDot();

            if (laatsteDot.getKleur().equals(nieuweDot.getKleur())) {
                if ((laatsteDot.getKolomIndex() - 1 == nieuweDot.getKolomIndex()) || (laatsteDot.getKolomIndex() == nieuweDot.getKolomIndex()) ||
                        (lijn.get(lijn.size()-1 ).getKolomIndex() + 1 == nieuweDot.getKolomIndex())) {
                    if ((laatsteDot.getRijIndex() - 1 == nieuweDot.getRijIndex()) || (laatsteDot.getRijIndex() == nieuweDot.getRijIndex()) ||
                            (laatsteDot.getRijIndex() + 1 == nieuweDot.getRijIndex())) {
                        lijn.add(lijn.size(),nieuweDot);
                    } else {
                        System.out.println("Bollen liggen niet naast elkaar; Dot 1: (" + laatsteDot.getKolomIndex() + ", " + laatsteDot.getRijIndex() + "); Dot 2: (" +
                                nieuweDot.getKolomIndex() + ", " + nieuweDot.getRijIndex() + ")");
                    }
                } else {
                    System.out.println("Bollen liggen niet naast elkaar; Dot 1: (" + laatsteDot.getKolomIndex() + ", " + laatsteDot.getRijIndex() + "); Dot 2: (" +
                            nieuweDot.getKolomIndex() + ", " + nieuweDot.getRijIndex() + ")");
                }
            } else {
                System.out.println("Bollen hebben niet dezelfde kleur; Dot 1: " + laatsteDot.getKleur() + "; Dot 2: " + nieuweDot.getKleur());
            }
        }
    }

    public DotConsole getLaatsteDot() {
        return lijn.get(lijn.size()-1);
    }

    public String printList() {
        for (DotConsole dotConsole : lijn) {
            return String.format("Kleur: " + dotConsole.getKleur() + "\nIndex [Kolom|Rij]: " + dotConsole.getKolomIndex()) + dotConsole.getRijIndex();
        }
        return "";
    }
}
