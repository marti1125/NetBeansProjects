/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willy
 */
public class ScopeOfVariable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int var1 = 10;
        int var2 = 15;

        if (var1 < 100) {
            var2 = 20;
        } else {
            var2 = 21;
        }

        // Access to var1 is allowed so no compile error.
        System.out.println("value of var1 = " + var1);

        // Access to var2 is not allowed so compile error will be generated
        System.out.println("value of var2 = " + var2);
    }
}
