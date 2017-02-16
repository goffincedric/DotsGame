package be.kdg.DotsConsole;

import java.util.Scanner;


/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:55
 */
public class MainConsole {
    public static void main(String[] args) {
        DotsConsole dotsConsole = new DotsConsole();
        SpelerConsole speler = new SpelerConsole();
        LijnConsole lijn = new LijnConsole();
        Scanner k = new Scanner(System.in);

        boolean stopBeurt;
        int kolom;
        int rij;

        System.out.print("Wat is je naam? ");
        speler.setNaam(k.nextLine());
        System.out.println("Welkom speler: " + speler.getNaam() + "\n");

        do {
            stopBeurt = false;
            do{
                dotsConsole.printveld();

                System.out.println();
                System.out.print("Geef index van dot [kolom]:  ");
                kolom = k.nextInt();
                System.out.print("Geef index van dot [rij]:  ");
                rij = k.nextInt();
                lijn.addDot(dotsConsole.getDotUitSpeelveld(rij, kolom));
                System.out.print(lijn.printList());

                System.out.printf("\n\nNog een dot verbinden(j/n)? ");
                String antwoord = k.next();
                if (antwoord.toLowerCase().equals("n")) {
                    stopBeurt = true;
                }
            } while(!stopBeurt);
            /* verwijder gebruikte dots*/
            dotsConsole.vervangGebruikteDots(lijn.getLijnDotArray());
            /* vervang verwijderde dots */

            /* bereken score*/

        } while (true);


    }
}
