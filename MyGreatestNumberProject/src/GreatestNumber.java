
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willy
 */
public class GreatestNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] num = new int[3];
        int counter;
        int max = 0;
        int totalnumber = 3;

        for(counter = 0; counter < totalnumber; counter++){
            num[counter] = Integer.parseInt
                    (JOptionPane.showInputDialog("Enter numbers until " + totalnumber + " numbers are entered"));
            if((counter == 0)||(num[counter] > max)){
                max = num[counter];
            }
            JOptionPane.showMessageDialog(null, "The number with the greatest value is " + max);
        }
    }

}
