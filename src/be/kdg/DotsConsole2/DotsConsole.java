package be.kdg.DotsConsole2;


/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:58
 */
public class DotsConsole {
   private final int MAXRIJ = 7;
   private final int MAXKOLOM = 7;
   private DotConsole[][] speelveld;

    public DotsConsole() {
        speelveld = new DotConsole[MAXRIJ][MAXKOLOM];

       for(int rij = 0; rij < MAXRIJ ;rij++){
           for (int kolom = 0; kolom < MAXKOLOM; kolom++){
               speelveld[rij][kolom] = new DotConsole(rij,kolom);
           }
       }
    }

    public void printveld() {
        for(int k=0; k <7; k++){
            System.out.print(" "+ k + "\t");
        }
        System.out.printf("\n\n");
        for (int i = 0; i < speelveld.length; i++) {
            for (int j = 0; j < speelveld[i].length; j++) {

                System.out.print("*" + speelveld[i][j].getKleur() + "\t");

            }
            System.out.println("\t" + i);
            System.out.println();

        }
    }


    public DotConsole[][] getSpeelveld() {
        return speelveld;
    }

    public DotConsole getDotUitSpeelveld(int rij, int kolom){
        return speelveld[rij][kolom];
    }
}
