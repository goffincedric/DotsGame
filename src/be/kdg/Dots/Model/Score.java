package be.kdg.Dots.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Properties;

/**
 * Dit is de klasse die de highscores beheerd.
 *
 * @author Cédric Goffin & Thomas Verhoeven
 * @version 1.0 5/02/2017 14:56
 */
public class Score extends Dots implements Serializable {
    private int Score;
    private String Naam;
    private int BehaaldLevel;

    /**
     *
     * @param naam De spelernaam waarvan de score word opgeslaan.
     * @param score De score van de speler die word opgeslaan.
     * @param level Het level van de speler warvan de score word opgeslaan
     */
    public Score(String naam, int score, int level) {
        this.Naam = naam;
        this.Score = score;
        this.BehaaldLevel = level;
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

    /**
     * Een inner class die opgegeven scores vergelijkt.
     */
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

    /**
     * Een inner class die alle highscores beheerd.
     */
    public static class HighScoreManager {
        private ArrayList<Score> scores;
        Properties properties = System.getProperties();
        private static String HIGHSCORE_FILE;

        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;

        public HighScoreManager() {
            scores = new ArrayList<Score>();
            HIGHSCORE_FILE = properties.getProperty("user.home") + File.separator + "HighScores.dat";
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

        /**
         * Deze methode voegt een score toe aan de highscoresfile.
         *
         * @param naam De spelernaam waarvan de score word opgeslaan.
         * @param score De score van de speler die word opgeslaan.
         * @param level Het level van de speler warvan de score word opgeslaan
         */
        public void addScore(String naam, int score, int level) {
            loadScoreFile();
            scores.add(new Score(naam, score, level));
            updateScoreFile();
        }

        /**
         * Een methode die de highscorefile ophaalt en inlaad in het programma.
         */
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

        /**
         * Een methode die de opgegeven score van de addScore()-methode toevoegt aan de highscorefile.
         */
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

        /**
         * Een methode die een string terugggeeft die de top 10 highscores bevat.
         */
        public String getHighscoreString() {
            String highscoreString = String.format("Plaats\t%-25s%-6s%-3s%n%n", "Spelernaam", "Score", "Level");
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

        /**
         * Een methode die kijkt of de opgegeven score een plaats in de top 10 heeft.
         *
         * @param score
         */
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
            return x + 2;
        }
    }
}
