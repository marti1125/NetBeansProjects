
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willy
 */
public class javaarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] fullname = new String[2];

        fullname[0] = JOptionPane.showInputDialog(fullname);
        fullname[1] = JOptionPane.showInputDialog(fullname);

        int a = fullname[0].length();
        int b = fullname[1].length();
        

        if(a > b){
            JOptionPane.showMessageDialog(null, fullname[0] + "has longer first name than " + fullname[1]);
        }else if(a < b){
            JOptionPane.showMessageDialog(null, fullname[1] + "has longer first name than " + fullname[0]);
        }
    }
}
