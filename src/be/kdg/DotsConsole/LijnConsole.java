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

    private List<DotConsole> lijn = new ArrayList<>();
    private int aantalDots = 0;
    private String lijnKleur;
    private DotsConsole consoleList;


    public void addDot(int kolom, int rij){
        //lijn.add(aantalDots, );
        aantalDots++;
    }
}
