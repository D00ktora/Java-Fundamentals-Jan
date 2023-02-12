/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 15:36
 */
package P21AssociativeArrays;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();
        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();
        String[] inputArr = input.split(" ");

        for (String s : inputArr) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s) + 1);
            }else {
                words.put(s, 1);
            }
        }
        List<String> tempList = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : words.entrySet()) {
            if (stringIntegerEntry.getValue() % 2 != 0) {
                tempList.add(stringIntegerEntry.getKey());
            }
        }

        System.out.println(String.join(", ", tempList));
    }
}
