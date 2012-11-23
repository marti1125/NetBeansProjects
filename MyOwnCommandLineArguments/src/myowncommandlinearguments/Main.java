/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myowncommandlinearguments;

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
        System.out.println("MY Family");

        if(args.length != 10){
            System.out.println("Please enter 5 members of your family");
            System.exit(0);
        }

        String m1 = args[0];
        String m2 = args[1];
        String m3 = args[2];
        String m4 = args[3];
        String m5 = args[4];
        String m6 = args[5];
        String m7 = args[6];
        String m8 = args[7];
        String m9 = args[8];
        String m10 = args[9];

        String fage01 = m1 + " "  +  m2;
        String fage02 = m3 + " "  +  m4;
        String fage03 = m5 + " "  +  m6;
        String fage04 = m7 + " "  +  m8;
        String fage05 = m9 + " "  +  m10;

        System.out.println(fage01 + "," + fage02 + "," + fage03 + "," + fage04 + "," + fage05);
    }
}
