package be.kdg.DotsConsole;

import be.kdg.Dots.Model.Dot;

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
        this.aantalDots = -1;
    }

    public List<DotConsole> getLijn() {
        return lijn;
    }

    public int getAantalDots() {
        return aantalDots;
    }

    public void setAantalDots(int aantalDots) {
        this.aantalDots = aantalDots;
    }

    public void addDot(int rij, int kolom) {

        DotConsole andereDot = this.getDotUitSpeelveld(rij, kolom);

        if (this.getAantalDots() == -1) {
            lijn.add(andereDot);
            setAantalDots(getAantalDots() + 1);


        } else {
            System.out.println(lijn.get(this.aantalDots).getKleur());
            if (lijn.get(this.aantalDots ).getKleur().equals(andereDot.getKleur())) {
                if ((lijn.get(this.aantalDots).getKolomIndex() - 1 == andereDot.getKolomIndex()) || (lijn.get(this.aantalDots).getKolomIndex() == andereDot.getKolomIndex()) || (lijn.get(this.aantalDots ).getKolomIndex() + 1 == andereDot.getKolomIndex())) {
                    if ((lijn.get(this.aantalDots).getRijIndex() - 1 == andereDot.getRijIndex()) || (lijn.get(this.aantalDots).getRijIndex() == andereDot.getRijIndex()) || (lijn.get(this.aantalDots).getRijIndex() + 1 == andereDot.getRijIndex())) {

                        lijn.add(andereDot);
                        setAantalDots(getAantalDots() + 1);

                    }
                }
            } else {
                System.out.println("Bollen hebben niet dezelfde kleur of liggen niet naast elkaar");
            }
        }



    }




    public String printList() {
        for (DotConsole dotConsole : lijn) {
            return String.format("Kleur: " + dotConsole.getKleur() + "\nIndex [Rij|Kolom]: " + dotConsole.getKolomIndex() + dotConsole.getRijIndex());

        }
        return "";
    }
}
