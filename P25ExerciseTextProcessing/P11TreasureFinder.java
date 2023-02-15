/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 15.2.2023 г.
 * Time: 5:19
 */
package P25ExerciseTextProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P11TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> integerList = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        input = scanner.nextLine();

        while (!input.contains("find")) {
            int integerLength = integerList.size();
            char[] stringBuilder = input.toCharArray();
            int j = 0;
            for (int i = 0; i < stringBuilder.length; i++) {
                char notModified = stringBuilder[i];
                char modified = (char) (notModified - integerList.get(j));
                j++;
                stringBuilder[i] = (char) modified;
                if (j == integerLength) {
                    //integerLength += integerLength;
                    j = 0;
                }
            }
            String join = "";
            for (char c : stringBuilder) {
                join += c;
            }

            StringBuilder treasure = new StringBuilder(join);
            int start = treasure.indexOf("&");
            treasure.deleteCharAt(start);
            int end = treasure.indexOf("&");
            String treasureFind = treasure.substring(start, end);
            start = treasure.indexOf("<");
            treasure.deleteCharAt(start);
            end = treasure.indexOf(">");
            treasure.deleteCharAt(end);
            String cordinates = treasure.substring(start,end);
            System.out.printf("Found %s at %s%n",treasureFind, cordinates);
            input = scanner.nextLine();
        }
    }
}
