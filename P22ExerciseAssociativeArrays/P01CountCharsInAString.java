/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 15:50
 */
package P22ExerciseAssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(" ");
        LinkedHashMap<Character, Integer> charMap = new LinkedHashMap<>();
        for (String s : inputArr) {
            for (int i = 0; i < s.length(); i++) {
                if (charMap.containsKey(s.charAt(i))) {
                    charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
                } else {
                    charMap.put(s.charAt(i), 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : charMap.entrySet()) {
            System.out.printf("%c -> %d%n",characterIntegerEntry.getKey(),characterIntegerEntry.getValue());

        }
    }
}
