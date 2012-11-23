package hallarcocienteresiduo;

import java.util.Scanner;

/**
 *
 * @author willy
 */
public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        double n1,n2;
        System.out.println("Ingrese el Primer numero: ");
        n1 = teclado.nextDouble();
        System.out.println("Ingrese el Segundo numero: ");
        n2 = teclado.nextDouble();

        //hallando el cociente
        double cociente = n1/n2;
        System.out.println("El Cociente es: " + cociente);

        //hallando el residuo
        double residuo = n1%n2;
        System.out.println("El Residuo es: " + residuo);
        
    }

}
