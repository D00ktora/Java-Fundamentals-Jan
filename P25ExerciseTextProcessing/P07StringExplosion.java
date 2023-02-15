/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 13.2.2023 г.
 * Time: 6:18
 */
package P25ExerciseTextProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder inputBuilder = new StringBuilder(input);
        int power = 0;

        for (int i = 0; i < inputBuilder.length(); i++) {
            char currentCharacter = inputBuilder.charAt(i);
            if (currentCharacter == '>') {
                power += Integer.parseInt(inputBuilder.charAt(i+1) + "");
            } else if (power > 0) {
                inputBuilder.deleteCharAt(i);
                power--;
                i--;
            }
        }

        System.out.println(inputBuilder);
    }
}
