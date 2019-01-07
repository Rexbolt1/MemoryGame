/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;
import java.util.*;
import java.io.*;
/**
 *
 * @author rexbolt1
 */
public class HighscoreManager {
    private ArrayList<Scores> scores;
    private static final String HIGHSCORE_FILE = "scores.dat";
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;
    
    public HighscoreManager() {
        //initialising the scores-arraylist
        scores = new ArrayList<Scores>();
    }
    
    public ArrayList<Scores> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    
    private void sort() {
        TheScoreComparator comparator = new TheScoreComparator();
        Collections.sort(scores, comparator);
    }
    
    public void addScore(String name, int score) {
        loadScoreFile();
        scores.add(new Scores(name, score));
        updateScoreFile();
    }
    
    public void loadScoreFile() {
      
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Scores>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }
    
 
    
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }
    
    
    
    public String getHighscoreString() {
        String highscoreString = "";
	int max = 10;

        ArrayList<Scores> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getNaam() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
}
    
}
