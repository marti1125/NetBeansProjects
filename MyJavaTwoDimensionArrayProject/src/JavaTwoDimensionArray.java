/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willy
 */
public class JavaTwoDimensionArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] ages = new int[10][5];

        System.out.println("age.length= " + ages.length);
        System.out.println("ages[1].length= " + ages[1].length);

        for(int i = 0; i < ages.length; i++){
            System.out.println("\nStarting row " + i);
            for(int j = 0; j < ages[i].length; j++){
                ages[i][j] = i * j;
                System.out.println(ages[i][j] + "");
            }
        }
    }

}
