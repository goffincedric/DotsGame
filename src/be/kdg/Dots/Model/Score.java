package be.kdg.Dots.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:56
 */
public class Score extends Dots implements Serializable {


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

    public static class ScoreComparator implements Comparator<Score> {
        public int compare(Score score1, Score score2) {
            int sc1 = score1.getScore();
            int sc2 = score2.getScore();
            if (sc1 > sc2) {
                return -1;
            } else if (sc1 > sc2) {
                return +1;
            } else if (sc1 == sc2) {
                if (score1.getBehaaldLevel() > score2.getBehaaldLevel()) {
                    return -1;
                } else if (score1.getBehaaldLevel() < score2.getBehaaldLevel()) {
                    return +1;
                } else {
                    return 0;
                }
            }
            return 0;
        }
    }


    public static class HighScoreManager {
        private ArrayList<Score> scores;
        private static final String HIGHSCORE_FILE = "HighScores.dat";

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

        private void sort() {
            ScoreComparator comparator = new ScoreComparator();
            Collections.sort(scores, comparator);
        }

        public void addScore(String naam, int score, int level) {
            loadScoreFile();
            scores.add(new Score(naam, score, level));
            updateScoreFile();
        }

        private void loadScoreFile() {
            try {
                inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
                scores = (ArrayList<Score>) inputStream.readObject();
            } catch (FileNotFoundException e) {
                System.out.println("[LAAD] Kan file met Highscores niet vinden");
            } catch (IOException e) {
                System.out.println("[LAAD] Input/Ouput exception: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("[LAAD] CNF Error " + e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("[LAAD] IO Error: " + e.getMessage());
                }
            }
        }

        public void updateScoreFile() {
            try {
                outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
                outputStream.writeObject(scores);

            } catch (FileNotFoundException e) {
                System.out.println("[UPDATE] Kan file met Highscores niet vinden");
            } catch (IOException e) {
                System.out.println("[UPDATE] Input/Ouput exception: " + e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("[UPDATE] IO Error: " + e.getMessage());
                }

            }
        }

        //scores herschrijven
        ///alles level hoger is dan komt hij hoger


        public String getHighscoreString() {
            String highscoreString = "";
            int max = 10;

            ArrayList<Score> scores;
            scores = getScores();

            int i = 0;
            int x = scores.size();
            if (x > max) {
                x = max;
            }
            while (i < x) {
                highscoreString += String.format("%3d.\t%-25s%-6s%-3s%n",(i + 1), scores.get(i).getNaam(), scores.get(i).getScore(), scores.get(i).getBehaaldLevel());
                i++;
            }
            return highscoreString;
        }

        public int isNewHighscore(int score) {
            ArrayList<Score> scores;
            scores = getScores();
            int x;


            if(scores.size() <= 9){
                x=scores.size()-1;
            }else{
                x=9;
            }

            while (x >= 0) {
                if (score > scores.get(x).getScore()) {
                    x--;
                } else {
                    return x+2;
                }


            }
            return -1;
        }
    }
}
