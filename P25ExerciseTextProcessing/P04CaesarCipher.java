/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 13.2.2023 г.
 * Time: 5:35
 */
package P25ExerciseTextProcessing;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        String encrypted = "";

        for (String s : input) {
            char charecter = s.charAt(0);
            charecter += 3;
            encrypted += charecter;
        }
        System.out.println(encrypted);
    }
}
