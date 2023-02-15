/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 13.2.2023 г.
 * Time: 4:58
 */
package P25ExerciseTextProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        String[] input = scanner.nextLine().split("\\s+");
        List<String> characterList1 = Arrays.stream(input[0].split("")).map(String::toString).collect(Collectors.toList());
        List<String> characterList2 = Arrays.stream(input[1].split("")).map(String::toString).collect(Collectors.toList());

        if (characterList1.size() > characterList2.size()) {
            for (int i = 0; i < characterList2.size(); i++) {
                int numChar1 = characterList1.get(i).charAt(0);
                int numChar2 = characterList2.get(i).charAt(0);
                int result = (numChar1 * numChar2);
                sum += result;
                characterList1.remove(characterList1.get(i));
                characterList2.remove(characterList2.get(i));
                i = -1;
            }
            for (String charsLeft : characterList1) {
                sum += charsLeft.charAt(0);
            }
        } else {
            for (int i = 0; i < characterList1.size(); i++) {
                int numChar1 = characterList1.get(i).charAt(0);
                int numChar2 = characterList2.get(i).charAt(0);
                int result = (numChar1 * numChar2);
                sum += result;
                characterList1.remove(characterList1.get(i));
                characterList2.remove(characterList2.get(i));
                i = -1;
            }
            for (String charsLeft : characterList2) {
                sum += charsLeft.charAt(0);
            }
        }
        System.out.println(sum);
    }
}
