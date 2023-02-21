/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 20.2.2023 г.
 * Time: 6:00
 */
package P30ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<pairs>(?<word1>[A-z]{3,})\\1\\1(?<word2>[A-z]{3,}))\\1");
        Matcher matcher = pattern.matcher(input);
        List<String> pairs = new ArrayList<>();
        List<String> mirroredWords = new ArrayList<>();
            while (matcher.find()){
                pairs.add(matcher.group("pairs"));
                String word1 = matcher.group("word1");
                String word2 = matcher.group("word2");
                if (areWordsTheSame(word1, word2)) {
                    String mirroredWord = word1 + " <=> " + word2;
                    mirroredWords.add(mirroredWord);
                }
            }
        if (!pairs.isEmpty()) {
            System.out.printf("%d word pairs found!%n",pairs.size());
        } else {
            System.out.println("No word pairs found!");
        }
        if (!mirroredWords.isEmpty()) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ",mirroredWords));
        } else {
            System.out.println("No mirror words!");
        }
    }

    private static boolean areWordsTheSame(String word1, String word2) {
        StringBuilder firstWord = new StringBuilder(word1);
        StringBuilder secondWord = new StringBuilder(word2);

        firstWord.reverse();
        if (firstWord.toString().equals(secondWord.toString())) {
            return true;
        }
        return false;
    }
}
