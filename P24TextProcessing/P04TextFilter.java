/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 12.2.2023 г.
 * Time: 10:54
 */
package P24TextProcessing;

import java.util.Scanner;

public class P04TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(",\\s+");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            int bannedWordLength = bannedWord.length();
            String replacement = "";
            for (int i = 0; i < bannedWordLength; i++) {
                replacement += "*";
            }
            while (text.contains(bannedWord)) {
                text = text.replace(bannedWord,replacement);
            }
        }

        System.out.println(text);
    }
}
