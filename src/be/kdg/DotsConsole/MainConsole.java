package be.kdg.DotsConsole;

import be.kdg.Dots.Model.Dot;
import be.kdg.Dots.Model.Speler;

import java.util.Scanner;


/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:55
 */
public class MainConsole {
    private static DotsConsole dotsConsole;
    private static SpelerConsole speler;
    private static LijnConsole lijn;

    public static void main(String[] args) {
        dotsConsole = new DotsConsole();
        speler = new SpelerConsole();
        lijn = new LijnConsole();
        Scanner k = new Scanner(System.in);

        boolean stopBeurt;
        int kolom;
        int rij;

        System.out.print("Wat is je naam? ");
        speler.setNaam(k.nextLine());
        System.out.println("Welkom speler: " + speler.getNaam() + "\n");
        dotsConsole.printVeld();
        do {
            stopBeurt = false;
            do{
                System.out.print("\nGeef index van dot [kolom]:  ");
                kolom = k.nextInt();
                System.out.print("Geef index van dot [rij]:  ");
                rij = k.nextInt();
                lijn.addDot(dotsConsole.getDotUitSpeelveld(rij, kolom));
                System.out.print(lijn.printList());

                System.out.printf("\n\nNog een dot verbinden(j/n)? ");
                String antwoord = k.next();
                if (antwoord.toLowerCase().equals("n")) {
                    stopBeurt = true;
                } else {
                    dotsConsole.printVeld();
                }
            } while(!stopBeurt);
            /* verwijder gebruikte dots*/
            dotsConsole.vervangGebruikteDots(lijn.getLijnDotArray());
            /* vervang verwijderde dots */

            /* bereken score*/

            /*Laat veld opnieuw zien*/
            dotsConsole.printVeld();
        } while (true);
    }


}
