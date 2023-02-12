/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 15:45
 */
package P21AssociativeArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).filter(word -> word.length() % 2 == 0).collect(Collectors.toList());
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
