package P05ExerciseDataTypesAndVariables;

import java.math.BigInteger;
import java.util.Scanner;

public class P01IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        int fourthNum = Integer.parseInt(scanner.nextLine());

        int sumTemp = firstNum + secondNum;
        sumTemp /= thirdNum;
        BigInteger result = BigInteger.valueOf(sumTemp);
        result = result.multiply(BigInteger.valueOf(fourthNum));
        System.out.println(result);
    }
}
