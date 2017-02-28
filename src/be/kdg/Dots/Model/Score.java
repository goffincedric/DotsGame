package be.kdg.Dots.Model;

import java.io.*;
import java.util.*;

/**
 * @author Cédric Goffin
 * @version 1.0 5/02/2017 14:56
 */
public class Score extends Dots {


    private int Score; //via getters krijgen in presenter
    private String Naam;
    private int BehaaldLevel;


    public Score(String naam, int score, int level) {
        this.Naam = naam;
        this.Score = score;
        this.BehaaldLevel = level; //getLevel().getGamelevel()
    }

    public int getScore() {
        return Score;
    }

    public String getNaam() {
        return Naam;
    }

    public int getBehaaldLevel() {
        return BehaaldLevel;
    }

    public class ScoreComparator implements Comparator<Score> {
        public int compare(Score score1, Score score2) {
            int sc1 = score1.getScore();
            int sc2 = score2.getScore();

            if (sc1 > sc2) {
                return -1;

            } else if (sc1 > sc2) {
                return +1;
            } else {
                if (score1.getBehaaldLevel() > score2.getBehaaldLevel()) {
                    return -1;
                } else if (score1.getBehaaldLevel() < score2.getBehaaldLevel()) {
                    return +1;
                } else {
                    return 0;
                }

            }
        }
    }


    public class HighScoreManager {
        private ArrayList<Score> scores;
        private static final String HIGHSCORE_FILE = "Files/HighScores.txt";

        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;

        public HighScoreManager() {
            scores = new ArrayList<Score>();
        }

        public ArrayList<Score> getScores() {
            loadScoreFile();
            sort();
            return scores;
        }

        private void sort(){
            ScoreComparator comparator = new ScoreComparator();
            Collections.sort(scores,comparator);
        }

        public void addScore(String naam, int score, int level){
            loadScoreFile();
            scores.add(new Score(naam, score, level));
            updateScoreFile();
        }

        private void loadScoreFile(){
            try{
                inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
                scores = (ArrayList<Score>) inputStream.readObject();
            }catch(FileNotFoundException e){
                System.out.println("[LAAD] Kan file met Highscores niet vinden");
            }catch(IOException e){
                System.out.println("[LAAD] Input/Ouput exception: " + e.getMessage());
            }catch(ClassNotFoundException e){
                System.out.println("[LAAD] CNF Error " + e.getMessage());
            } finally {
                try{
                    if (outputStream != null){
                        outputStream.flush();
                        outputStream.close();
                    }
                }catch (IOException e){
                    System.out.println("[LAAD] IO Error: " + e.getMessage());
                }
            }
        }

        public void updateScoreFile(){
            try{
                outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
                outputStream.writeObject(scores);

            }catch(FileNotFoundException e){
                System.out.println("[UPDATE] Kan file met Highscores niet vinden");
            }catch(IOException e) {
                System.out.println("[UPDATE] Input/Ouput exception: " + e.getMessage());
            }finally {
                try{
                    if (outputStream != null){
                        outputStream.flush();
                        outputStream.close();
                    }
                }catch (IOException e){
                    System.out.println("[UPDATE] IO Error: " + e.getMessage());
                }

            }
        }

        public String getHighscoreFile(){
            String HighScoreString = "";

            ArrayList<Score> scores;
            scores = getScores();

            int i = 0;
            int x = scores.size();

            return  HighScoreString;
        }
    }
}
