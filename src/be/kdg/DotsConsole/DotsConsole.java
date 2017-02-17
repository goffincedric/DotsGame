package be.kdg.DotsConsole;


/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:58
 */
public class DotsConsole extends MainConsole {
    private final int MAXRIJ = 7;
    private final int MAXKOLOM = 7;
    private DotConsole[][] speelveld;

    public DotsConsole() {
        speelveld = new DotConsole[MAXRIJ][MAXKOLOM];

        for (int rij = 0; rij < MAXRIJ; rij++) {
            for (int kolom = 0; kolom < MAXKOLOM; kolom++) {
                speelveld[rij][kolom] = new DotConsole(rij, kolom);
            }
        }
    }

    public void printVeld() {
        for (int k = 0; k < 7; k++) {
            System.out.print(" " + k + "\t");
        }
        System.out.printf("\n\n");
        for (int i = 0; i < speelveld.length; i++) {
            for (int j = 0; j < speelveld[i].length; j++) {
                String teken = "-";
                teken = getLijn().getDot(i,j) == getDotUitSpeelveld(i, j)?"°":"*";

                System.out.print(teken + speelveld[i][j].getKleur() + "\t");
            }
            System.out.println("\t" + i);
            System.out.println();
        }
    }


    public DotConsole[][] getSpeelveld() {
        return speelveld;
    }

    public DotConsole getDotUitSpeelveld(int rij, int kolom) {
        return speelveld[rij][kolom];
    }

    public void vervangGebruikteDots(DotConsole[] gebruikteDots, DotConsole[][] speelveld) {
        for (DotConsole dot : gebruikteDots) {
            this.speelveld[dot.getRijIndex()][dot.getKolomIndex()] = null;
        }

        for (int i = MAXRIJ -1; i >= 0; i--) {
            for (int j = MAXKOLOM -1; j >= 0 ; j--) {
                if (speelveld[i][j] == null) {
                    int rijTeller = i;
                     do {
                         rijTeller--;
                     } while (speelveld[rijTeller][j] == null && rijTeller > -1);

                    speelveld[i][j] = speelveld[rijTeller][j];
                    speelveld[rijTeller][j] = null;

                    /* nog niet klaar*/
                }
            }
        }

    }


}
