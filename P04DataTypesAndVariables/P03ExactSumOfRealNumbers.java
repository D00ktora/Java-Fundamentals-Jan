package P04DataTypesAndVariables;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class P03ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(String.valueOf(0));
        for (int i = 0; i < iterations; i++) {
            BigDecimal number = new BigDecimal(String.valueOf(scanner.nextLine()));
            sum = sum.add(number);
        }
        System.out.println(sum);
    }
}
