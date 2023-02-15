/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 13.2.2023 г.
 * Time: 5:51
 */
package P25ExerciseTextProcessing;

import java.util.*;
import java.util.stream.Collectors;

public class P06ReplaceRepeatingChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        List<String> chars = new ArrayList<>(Arrays.stream(input).collect(Collectors.toList()));

        for (int i = 0; i < chars.size() - 1; i++) {
            if (chars.get(i).equals(chars.get(i+1))) {
                chars.remove(i);
                i = -1;
            }
        }
        String finished = "";
        for (String aChar : chars) {
            finished+=aChar;
        }
        System.out.println(finished);

    }
}
