/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoreferencisa;

/**
 *
 * @author willy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] ages = {10, 12, 11};
        for (int a = 0; a < ages.length; a++) {
            System.out.println(ages[a]);
        }
        test(ages);        
        for (int a = 0; a < ages.length; a++) {
            System.out.println(ages[a]);
        }
    }

    public static void test(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 50;
        }
    }
}
