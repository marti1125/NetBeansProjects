package fibonacci;

/**
 *
 * @author willy
 */
public class Main {


    public static void main(String[] args) {

        int f1 = 0;
        int f2 = 1;
        System.out.println(f1);//imprime el valor de fi que es 0
        while (f1 < 100) {
            System.out.println(f2);//imprime el valor de fi
            f2 += f1;
            f1 = f2 - f1;
        }

    }
}
