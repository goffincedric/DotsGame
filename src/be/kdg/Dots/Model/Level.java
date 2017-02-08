package be.kdg.Dots.Model;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:50
 */
public class Level {
    private int tijd; //in seconden
    private int teBehalenScore;



    public Level( int teBehalenScore) {
        this.tijd = 45;
        this.teBehalenScore = teBehalenScore;
    }


    public int getTeBehalenScore() {
        return teBehalenScore;
    }

    public void setTeBehalenScore(int teBehalenScore) {
        this.teBehalenScore = teBehalenScore;
    }

    public void nextLevel(){
        //value voor nextlevel
        setTeBehalenScore(getTeBehalenScore()+30);
    }
}
