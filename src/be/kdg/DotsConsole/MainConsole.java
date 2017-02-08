package be.kdg.DotsConsole;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:55
 */
public class MainConsole {
    public static void main(String[] args) {
        DotsConsole dotsGame = new DotsConsole();
        SpelerConsole speler = new SpelerConsole();
        LijnConsole lijn = new LijnConsole();
        Scanner k = new Scanner(System.in);
        int colom;
        int rij;


        System.out.println("Wat is je naam? ");
        speler.setNaam(k.nextLine());
        System.out.println("Welkom speler: " + speler.getNaam() + "\n");


        dotsGame.printveld();
        System.out.println(dotsGame.getDotUitSpeelveld(0,0).toString());
        System.out.println(dotsGame.getDotUitSpeelveld(0,6).toString());
        System.out.println(dotsGame.getDotUitSpeelveld(6,0).toString());
        System.out.println(dotsGame.getDotUitSpeelveld(6,6).toString());
        do{
        System.out.println();
        System.out.println("Geef index van dot [kolom]:  ");
        colom = k.nextInt();
        System.out.println("Geef index van dot [rij]:  ");
        rij = k.nextInt();
        lijn.addDot(dotsGame.getDotUitSpeelveld(rij,colom));
        System.out.print(lijn.printList());
            System.out.println(lijn.getLijn().size());

        System.out.println();
        }while(true);



    }
}
