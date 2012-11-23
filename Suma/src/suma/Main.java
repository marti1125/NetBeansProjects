package suma;

import java.util.Scanner;


//autor: Willy Aguirre

public class Main {

    public static void main(String[] args) {

        //instancia de objeto de nombre teclado me permite ingresar datos por consola
        Scanner teclado = new Scanner(System.in);

        double a = 5;
        double b = 10;
        String ingreso = "";

        System.out.println("ingrese la operacion que desea realizar: +,-,/,*");
        ingreso = teclado.next();

        if(ingreso.equals("+")){
            double suma;
            suma = a + b;
            System.out.println("la suma es: " + suma);
        }else if(ingreso.equals("-")){
            double resta;
            resta = a - b;
            System.out.println("la resta es: " + resta);
        }else if(ingreso.equals("/")){
            double dividir;
            dividir = a / b;
            System.out.println("la divicion es: " + dividir);
        }else if(ingreso.equals("*")){
            double multiplicacion;
            multiplicacion = a * b;
            System.out.println("la multiplicacion es: " + multiplicacion);
        }
        
    }

}
