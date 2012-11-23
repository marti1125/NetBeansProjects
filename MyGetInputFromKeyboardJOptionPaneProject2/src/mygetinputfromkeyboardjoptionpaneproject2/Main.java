package mygetinputfromkeyboardjoptionpaneproject2;

import javax.swing.JOptionPane;

/**
 *
 * @author willy
 */
public class Main {

    public static void main(String[] args) {

        String name = "";        
        String age = "";
        name = JOptionPane.showInputDialog("Please enter your name");
        age = JOptionPane.showInputDialog("Please enter your age");

        String msg = "Hello " + name + " you are young!";
        String msg2 = "Hello " + name + " you are old!";

        int ageint = Integer.parseInt(age);

        if(ageint < 100){
            JOptionPane.showMessageDialog(null, msg);
        }else{
            JOptionPane.showMessageDialog(null, msg2);
        }
    }

}
