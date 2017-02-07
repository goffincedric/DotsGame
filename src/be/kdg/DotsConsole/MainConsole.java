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
        do{
        System.out.println();
        System.out.println("Geef index van dot [colom]:  ");
        colom = k.nextInt();
        System.out.println("Geef index van dot [rij]:  ");
        rij = k.nextInt();
        lijn.addDot(rij, colom);
        System.out.print(lijn.printList());

        System.out.println();
        }while(true);



    }
}
