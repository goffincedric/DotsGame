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
    private static SpelerConsole spelerConsole;
    private static LijnConsole lijnConsole;

    public static void main(String[] args) {
        dotsConsole = new DotsConsole();
        spelerConsole = new SpelerConsole();
        lijnConsole = new LijnConsole();
        Scanner k = new Scanner(System.in);

        boolean stopBeurt;
        int rij = 0;
        int kolom = 0;
        int nieuwRij, nieuwKolom;

        System.out.print("Wat is je naam? ");
        spelerConsole.setNaam(k.nextLine());
        System.out.println("Welkom spelerConsole: " + spelerConsole.getNaam() + "\n");
        dotsConsole.printVeld();
        do {
            stopBeurt = false;
            do{
                System.out.print("\nGeef index van dot [kolom]:  ");
                nieuwKolom = k.nextInt();
                System.out.print("Geef index van dot [rij]:  ");
                nieuwRij = k.nextInt();

                try {
                    lijnConsole.addDot(dotsConsole.getDotUitSpeelveld(nieuwRij, nieuwKolom));
                } catch (DotsConsoleException e) {
                    System.out.println(e.getMessage());
                    nieuwKolom = kolom;
                    nieuwRij = rij;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ongeldige coördinaten, probeer opnieuw");
                }

                System.out.print(lijnConsole.printList());

                System.out.printf("\n\nNog een dot verbinden(j/n)? ");
                String antwoord = k.next();
                if (antwoord.toLowerCase().equals("n")) {
                    if (lijnConsole.getAantalDots() > 1) {
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
           dotsConsole.vervangGebruikteDots(lijnConsole.getLijnDotArray());

            /* berekent score*/
            spelerConsole.setScore(spelerConsole.getScore() + lijnConsole.getAantalDots());

            /* maakt lijn leeg*/
            lijnConsole = new LijnConsole();

            /* Laat veld opnieuw zien */
            dotsConsole.printVeld();
        } while (true);
    }

    public static SpelerConsole getSpelerConsole() {
        return spelerConsole;
    }

    public static LijnConsole getLijnConsole() {
        return lijnConsole;
    }



}
