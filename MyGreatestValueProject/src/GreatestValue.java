
/**
 *
 * @author willy
 */
public class GreatestValue {

    public static void main(String[] args) {

        int n1 = 10;
        int n2 = 23;
        int n3 = 5;

        int max = 0;

        max = (n1 > n2)?n1:n2;
        max = (max > n3)?max:n3;

        System.out.println("numero 1 :" + n1);
        System.out.println("numero 2 :" + n2);
        System.out.println("numero 3 :" + n3);
        System.out.println("el numero mayor es :" + max);
    }
}
