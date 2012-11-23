
/**
 *
 * @author willy
 */
public class ConditionalOperator {

    public static void main(String[] args) {

        String status = "";
        int grade = 80;

        //condicional IF
        status = (grade >= 60) ? "Passed" : "Failed";

        System.out.println(status);

        int salary = 100000;

        status = (salary > 50000) ? "You are rich!":"You are poor!";

        System.out.println(status);

    }
}
