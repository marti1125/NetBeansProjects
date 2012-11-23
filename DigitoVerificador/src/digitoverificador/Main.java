package digitoverificador;

import java.util.Scanner;

/**
 *
 * @author willy
 */
public class Main {

    public static void main(String[] args) {

        String ingreso = "";
        int array[];

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el codigo Verificor: ");
        ingreso = teclado.next();

        int longitud = ingreso.length();
        array = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            array[i] = Integer.parseInt(ingreso.substring(i, i + 1));
        }
        //multiplicando * 2
        System.out.println("Verificando......");
        array[0] = array[0] * 1; //2
        array[1] = array[1] * 2; //2
        if (array[1] > 9) {
            array[1] = array[1] - 9;
        }
        array[2] = array[2] * 1; //9
        array[3] = array[3] * 2; //0
        if (array[3] > 9) {
            array[3] = array[3] - 9;
        }
        array[4] = array[4] * 1; //0
        array[5] = array[5] * 2; //1
        if (array[5] > 9) {
            array[5] = array[5] - 9;
        }
        array[6] = array[6] * 1; //1
        array[7] = array[7] * 2; //1
        if (array[7] > 9) {
            array[7] = array[7] - 9;
        }
        array[8] = array[8] * 1; //0
        array[9] = array[9] * 2; //4
        if (array[9] > 9) {
            array[9] = array[9] - 9;
        }        

        int arrayTotal = new int[array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + array[6] + array[7] + array[8]
                + array[9] + array[10]].length;

        int resultado = arrayTotal % 10;

        if (resultado == 0) {
            System.out.println("la cédula es valida");
        } else {
            System.out.println("la cédula es incorrecta");
        }
    }
}
