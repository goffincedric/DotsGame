package be.kdg.DotsConsole2;

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
        int kolom;
        int rij;

        System.out.print("Wat is je naam? ");
        speler.setNaam(k.nextLine());
        System.out.println("Welkom speler: " + speler.getNaam() + "\n");


        dotsConsole.printveld();
        System.out.println(dotsConsole.getDotUitSpeelveld(0,0).toString());
        System.out.println(dotsConsole.getDotUitSpeelveld(0,6).toString());
        System.out.println(dotsConsole.getDotUitSpeelveld(6,0).toString());
        System.out.println(dotsConsole.getDotUitSpeelveld(6,6).toString());
        do{
        System.out.println();
        System.out.println("Geef index van dot [kolom]:  ");
        kolom = k.nextInt();
        System.out.println("Geef index van dot [rij]:  ");
        rij = k.nextInt();
        lijn.addDot(dotsConsole.getDotUitSpeelveld(rij,kolom));
        System.out.print(lijn.printList());

        System.out.println();
        }while(true);



    }
}
