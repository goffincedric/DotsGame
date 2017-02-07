package be.kdg.DotsConsole;



/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:58
 */
public class DotsConsole {
   private final int MAXRIJ = 7;
   private final int MAXKOLOM = 7;
   private DotConsole[][] speelveld;
   DotConsole dot;

    public DotsConsole() {
        speelveld = new DotConsole[MAXRIJ][MAXKOLOM];

       for(int i = 0; i < speelveld.length ;i++){
           for (int j = 0; j < speelveld[i].length; j++){
               speelveld[i][j] = new DotConsole(i,j);
           }

       }
    }

    public void printveld() {


        for(int k=0; k <7; k++){
            System.out.print(" "+ k + "\t");
        }
        System.out.println();
        System.out.println();

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
