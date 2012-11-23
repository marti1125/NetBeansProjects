/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjstore;

import gui.Principal;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author willly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Principal p = new Principal();
            p.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sistema Operativo no Soportado");
        }
    }
}
