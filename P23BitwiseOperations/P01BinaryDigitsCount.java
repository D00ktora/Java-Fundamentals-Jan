/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 12.2.2023 г.
 * Time: 9:55
 */
package P23BitwiseOperations;

import java.util.Scanner;

public class P01BinaryDigitsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int B = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while (!(number == 0)) {
            if (number % 2 == B) {
                count++;
            }
            number /= 2;
        }

        System.out.println(count);
    }
}
