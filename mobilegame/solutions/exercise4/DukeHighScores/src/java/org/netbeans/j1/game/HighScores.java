/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.j1.game;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Lukas
 */
@WebService()
public class HighScores {

    private final int HIGH_SCORES = 9;
    private int lastHighScore = 0;
    private String[] names = new String[HIGH_SCORES];
    private int[] scores = new int[HIGH_SCORES];

    public HighScores() {
        for (int i = 0; i < HIGH_SCORES; i++) {
            names[i] = "Empty";
            scores[i] = 0;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getHighScores")
    public String[] getHighScores() {
        String text[] = new String[9];
        for (int i = 0; i < HIGH_SCORES; i++) {
            text[i] = names[i] + ":" + scores[i];
        }
        return text;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "setHighScore")
    public boolean setHighScore(
            @WebParam(name = "name") String name, 
            @WebParam(name = "score") int score) {
        if (score > scores[lastHighScore]) {
            int buble = score;
            String bubleName = name;
            for ( int i = 0; i < HIGH_SCORES; i++) {
                if (buble > scores[i]) {
                    int temp = scores[i];
                    String tempName = names[i];
                    scores[i] = buble;
                    names[i] = bubleName;
                    buble = temp;
                    bubleName = tempName;
                }
            }
            if (lastHighScore < HIGH_SCORES) {
                lastHighScore++;
            }
            return true;
        } else {
            return false;
        }
    }
}
