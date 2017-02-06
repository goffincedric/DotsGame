package be.kdg.DotsConsole;

import be.kdg.Dots.Dots;
import be.kdg.DotsConsole.DotsConsole;
import java.util.Scanner;


/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:55
 */
public class MainConsole {
    public static void main(String[] args) {
        DotsConsole dotsGame = new DotsConsole();
        SpelerConsole speler = new SpelerConsole();
        Scanner k = new Scanner(System.in);

        System.out.println("Wat is je naam? ");
        speler.setNaam(k.nextLine());
        System.out.println("Welkom speler: " + speler.getNaam() + "\n");


        dotsGame.printveld();
    }
}
