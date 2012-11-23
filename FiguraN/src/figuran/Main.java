package figuran;

import java.util.Scanner;

/**
 *
 * @author willy
 */
public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        
        int width,height;

        System.out.println("Ingrese Ancho: ");
        width = teclado.nextInt();
        System.out.println("Ingrese Altura: ");
        height = teclado.nextInt();

        width = width / 2 * 2 + 1;

        height = height / 2 * 2 + 1;

        int sequenceValue = 0;



        for (int row = 1; row <= height; row++) {

            sequenceValue += 1;

            for (int column = 1; column <= width; column++) {
                if (sequenceValue == width * height / 2 + 1) {
                    System.out.print("   ");
                } else {
                    System.out.print("**");
                }
            }

            System.out.println();

        }
    }
}
