package tipotriangulo;

import java.util.Scanner;

/**
 *
 * @author willy
 */
public class Main {

    public static void main(String[] args) {

        Scanner en = new Scanner(System.in);
        double a,b,c;
        System.out.print("Ingrese el Lado A del triangulo: ");
        a = en.nextDouble();
        System.out.print("Ingrese el Lado B del triangulo: ");
        b = en.nextDouble();
        System.out.print("Ingrese el Lado C del triangulo: ");
        c = en.nextDouble();

        if(a == b && a == c && b == a && b == c && c == a && c == b){
            System.out.println("Es un triaungulo equilátero");
        }else if(a == b || a == c || b == a || b == c || c == a || c == b){
            System.out.println("Es un triaungulo isósceles");
        }else{
            System.out.println("Es un triaungulo escaleno");
        }

    }

}
