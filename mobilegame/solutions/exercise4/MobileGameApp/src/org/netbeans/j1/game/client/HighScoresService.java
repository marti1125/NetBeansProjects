package org.netbeans.j1.game.client;
import javax.xml.namespace.QName;

public interface HighScoresService extends java.rmi.Remote {
    
    /**
     *
     */
    public boolean setHighScore(String name, int score) throws java.rmi.RemoteException;
    
    /**
     *
     */
    public String[] getHighScores() throws java.rmi.RemoteException;
    
}
