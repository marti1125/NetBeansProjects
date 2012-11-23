/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myownwhileproject;

import javax.swing.JOptionPane;

/**
 *
 * @author willy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String names[] = {"Beah", "Bianca", "Lance", "Belle", "Nico", "Yza", "Gem", "Ethan"};


        String searchName = JOptionPane.showInputDialog("Enter either \"Yza\" or \"noname\"!");


        boolean foundName = false;


//        for (int i = 0; i < names.length; i++) {
//            if (names[i].equals(searchName)) {
//                foundName = true;
//                break;
//            }
//        }
        int i = 0;
        while (i < names.length) {            
            if (names[i].equals(searchName)) {
                foundName = true;
                break;
            }
            i++;
        }


        if (foundName) {
            JOptionPane.showMessageDialog(null, searchName + " is found!");
        } else {
            JOptionPane.showMessageDialog(null, searchName + " is not found!");
        }

    }
}
