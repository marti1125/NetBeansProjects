/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package stockv02;

/**
 *
 * @author willly
 */
import gui.Principal;
import javax.swing.UIManager;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            //carga la interfas para linux
            String lnx = "linux";
            String c = "Linux";
            if(lnx.equals("linux") || c.equals("Linux")){
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            }          
            Principal p = new Principal();
            p.setVisible(true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
