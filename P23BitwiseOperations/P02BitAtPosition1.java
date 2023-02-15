/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 12.2.2023 г.
 * Time: 10:01
 */
package P23BitwiseOperations;

import java.util.*;

public class P02BitAtPosition1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        while (!(number == 0)) {
            numbers.add(number%2);
            number /= 2;
        }
        System.out.println(numbers.get(0));
    }
}
