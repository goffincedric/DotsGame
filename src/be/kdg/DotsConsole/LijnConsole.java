package be.kdg.DotsConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Verhoeven
 * @version 1.0 6/02/2017 22:01
 */
public class LijnConsole extends DotsConsole{

    //vraag user naar kolom en rij
    //blijf dit doen in een loop
    //vergelijk steeds de  dots

    private List<DotConsole> lijn = new ArrayList<>();
    private int aantalDots = 0;
    private String lijnKleur;





    public void addDot(int  rij, int kolom){
        lijn.add(aantalDots,this.getDotUitSpeelveld(rij, kolom) );
        //dot uit speelveld kunnen halen via rij en colomnindex
        //lijn.add(aantalDots,.getDotUitSpeelveld(kolom,rij));
        aantalDots++;
    }

    public List<DotConsole> getLijn() {
        return lijn;
    }


    public String printList() {
        for (DotConsole dotConsole : lijn) {
            return String.format("Kleur: " + dotConsole.getKleur() + "\nIndex[Rij|Kolom]: " + dotConsole.getKolomIndex() + dotConsole.getRijIndex());

        }
        return "";
    }
}
