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
        int rij = 0;
        int kolom = 0;
        int nieuwRij, nieuwKolom;

        System.out.print("Wat is je naam? ");
        speler.setNaam(k.nextLine());
        System.out.println("Welkom speler: " + speler.getNaam() + "\n");
        dotsConsole.printVeld();
        do {
            stopBeurt = false;
            do{
                System.out.print("\nGeef index van dot [kolom]:  ");
                nieuwKolom = k.nextInt();
                System.out.print("Geef index van dot [rij]:  ");
                nieuwRij = k.nextInt();

                try {
                    lijn.addDot(dotsConsole.getDotUitSpeelveld(nieuwRij, nieuwKolom));
                } catch (DotsConsoleException e) {
                    System.out.println(e.getMessage());
                    nieuwKolom = kolom;
                    nieuwRij = rij;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ongeldige coördinaten, probeer opnieuw");
                }

                System.out.print(lijn.printList());

                System.out.printf("\n\nNog een dot verbinden(j/n)? ");
                String antwoord = k.next();
                if (antwoord.toLowerCase().equals("n")) {
                    if (lijn.getAantalDots() > 1) {
                        stopBeurt = true;
                    } else {
                        dotsConsole.printVeld();
                        System.out.println("\nLijn niet lang genoeg, minstens 2 bollen nodig");
                    }
                } else {
                    dotsConsole.printVeld();
                }
            } while(!stopBeurt);
            /* verwijdert gebruikte dots*/
           dotsConsole.vervangGebruikteDots(lijn.getLijnDotArray());

            /* berekent score*/
            speler.setScore(speler.getScore() + lijn.getAantalDots());

            /* maakt lijn leeg*/
            lijn = new LijnConsole();

            /* Laat veld opnieuw zien */
            dotsConsole.printVeld();
        } while (true);
    }

    public static DotsConsole getDotsConsole() {
        return dotsConsole;
    }

    public static SpelerConsole getSpeler() {
        return speler;
    }

    public static LijnConsole getLijn() {
        return lijn;
    }



}
