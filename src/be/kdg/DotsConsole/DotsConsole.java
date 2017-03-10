package be.kdg.DotsConsole;



/**
 * @author Cédric Goffin & Thomas Verhoeven
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
                teken = super.getLijnConsole().getDot(i, j) == getDotUitSpeelveld(i, j) ? "°" : "*";

                System.out.print(teken + speelveld[i][j].getKleur() + "\t");
            }
            System.out.println("\t" + i + "\n");
        }
        System.out.printf("Huidige score: %d", super.getSpelerConsole().getScore());
    }


    public DotConsole[][] getSpeelveld() {
        return speelveld;
    }

    public DotConsole getDotUitSpeelveld(int rij, int kolom) {
        return speelveld[rij][kolom];
    }

    public void vervangGebruikteDots(DotConsole[] gebruikteDots) {
        for (DotConsole dot : gebruikteDots) {
            this.speelveld[dot.getRijIndex()][dot.getKolomIndex()] = null;
        }

        int rijTeller;

        for (int i = MAXRIJ - 1; i >= 0; i--) {
            for (int j = MAXKOLOM - 1; j >= 0; j--) {
                if (speelveld[i][j] == null) {
                    rijTeller = i;
                    do {
                        rijTeller--;
                    } while ((rijTeller == -1) ? false : (speelveld[rijTeller][j] == null) && rijTeller > -1);

                    switch (rijTeller) {
                        case -1:
                            for (int k = 0; k <= i; k++) {
                                speelveld[k][j] = new DotConsole(k, j);
                            }
                            break;
                        default:
                            speelveld[i][j] = speelveld[rijTeller][j];
                            speelveld[rijTeller][j] = null;
                            break;
                    }
                }
            }
        }

    }


}
