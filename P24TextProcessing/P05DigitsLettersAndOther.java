/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 12.2.2023 г.
 * Time: 11:04
 */
package P24TextProcessing;

import java.util.Scanner;

public class P05DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");
        String chars = "";
        String numbers = "";
        String other = "";
        for (String charecter : input){
            if (Character.isDigit(charecter.charAt(0))) {
                numbers += charecter;
            } else if (Character.isLetter(charecter.charAt(0))) {
                chars += charecter;
            } else {
                other += charecter;
            }
        }
        System.out.println(numbers);
        System.out.println(chars);
        System.out.println(other);
    }
}
