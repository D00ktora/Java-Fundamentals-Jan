/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 12.2.2023 г.
 * Time: 10:29
 */
package P24TextProcessing;

import java.util.*;
import java.util.stream.Collectors;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        String input;

        while (!"end".equals(input = scanner.nextLine())) {
            words.add(input);
        }
        List<String> reversWord = new ArrayList<>();
        for (String word : words) {
            List<String> tempReversWord = Arrays.stream(word.split("")).map(String::toString).collect(Collectors.toList());
            Collections.reverse(tempReversWord);
            String revers = "";
            for (String s : tempReversWord) {
                revers += s;
            }
            reversWord.add(revers);
        }
        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%s = %s%n", words.get(i), reversWord.get(i));
        }
    }
}
