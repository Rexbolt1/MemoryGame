/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorygame;
import java.io.Serializable;
/**
 *
 * @author rexbolt1
 */
public class Scores implements Serializable {
    private int score;
    private String naam;

    public int getScore() {
        return score;
    }

    public String getNaam() {
        return naam;
    }

    public Scores(String naam, int score) {
        this.score = score;
        this.naam = naam;
    }
}
