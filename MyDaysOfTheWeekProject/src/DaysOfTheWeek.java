/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willy
 */
public class DaysOfTheWeek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] days = {"Sunday","Monday","Tuesday","Wednesday",
        "Thursday","Friday","Saturday"};

        System.out.println("Display days of week using while loop");

        int counter = 0;
        while(counter < days.length){
            System.out.println(days[counter]);
            counter++;
        }

        System.out.println("Display days of week using do-while loop");

        counter = 0;
        do{
            System.out.println(days[counter]);
            counter++;
        }while(counter < days.length);

        System.out.println("Display days of week using for loop");
        for(counter = 0; counter < days.length; counter++){
             System.out.println(days[counter]);
        }
    }

}
