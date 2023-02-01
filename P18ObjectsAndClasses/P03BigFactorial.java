/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 31.1.2023 г.
 * Time: 18:27
 */
package P18ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class P03BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        System.out.println(factorial(i));
    }
    public static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
}
