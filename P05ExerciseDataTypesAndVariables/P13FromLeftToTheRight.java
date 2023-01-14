package P05ExerciseDataTypesAndVariables;

import java.math.BigInteger;
import java.util.Scanner;

public class P13FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        String number = "";
        int result = 0;
        for (int i = 0; i <numberOfLines; i++) {
            BigInteger firstNumber = scanner.nextBigInteger();
            BigInteger secondNumber = scanner.nextBigInteger();
            if (firstNumber.longValue() > secondNumber.longValue()){
                number = String.valueOf(firstNumber);
            }else {
                number = String.valueOf(secondNumber);
            }
            int differentStart = 0;
            if (number.charAt(0) == '-'){
                differentStart = 1;
            }
            for (int j = differentStart; j < number.length(); j++) {
                result += Integer.parseInt(number.valueOf(number.charAt(j)));
            }
            System.out.println(result);
            result = 0;
        }
    }
}
