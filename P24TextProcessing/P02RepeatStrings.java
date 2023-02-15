/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 12.2.2023 г.
 * Time: 10:43
 */
package P24TextProcessing;

import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            int reps = word.length();
            for (int i = 0; i < reps; i++) {
                result.append(word);
            }
        }

        System.out.println(result);
    }
}
