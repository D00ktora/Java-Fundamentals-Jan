/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 14:59
 */
package P21AssociativeArrays;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Integer> arrInts = new TreeMap<>();
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            if (arrInts.containsKey(Integer.parseInt(input[i]))) {
                arrInts.put(Integer.parseInt(input[i]), arrInts.get(Integer.parseInt(input[i])) + 1);
            } else {
                arrInts.put(Integer.parseInt(input[i]), 1);
            }
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : arrInts.entrySet()) {
            System.out.printf("%d -> %d%n",integerIntegerEntry.getKey(),integerIntegerEntry.getValue());

        }
    }

}
