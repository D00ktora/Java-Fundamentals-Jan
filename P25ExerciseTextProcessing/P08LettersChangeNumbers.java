/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 15.2.2023 г.
 * Time: 4:51
 */
package P25ExerciseTextProcessing;

import java.io.FilterOutputStream;
import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] inputArr = input.split("\\s+");
        double sum = 0;
        for (String code : inputArr) {
            char operationOne = code.charAt(0);
            char operationTwo = code.charAt(code.length() - 1);
            StringBuilder codeModified = new StringBuilder(code);
            codeModified.deleteCharAt(0);
            codeModified.deleteCharAt(codeModified.length() - 1);
            double number = Double.parseDouble(codeModified.toString());
            double result = modifiedNumber(operationOne, operationTwo, number);
            sum += result;
        }

        System.out.printf("%.2f", sum);
    }

    private static double modifiedNumber(char operationOne, char operationTwo, double number) {
        double result = 0;
        if (operationOne >= 'A' && operationOne <= 'Z') {
            //divide
            int charPosition = operationOne - 'A' + 1;
            result = number / (charPosition * 1.0);
        } else if (operationOne >= 'a' && operationOne <= 'z') {
            //multiply
            int charPosition = operationOne - 'a' + 1;
            result = number * charPosition * 1.0;
        }

        if (operationTwo >= 'A' && operationTwo <= 'Z') {
            //subtract
            int charPosition = operationTwo - 'A' + 1;
            result -= charPosition;
        } else if (operationTwo >= 'a' && operationTwo <= 'z') {
            //add
            int charPosition = operationTwo - 'a' + 1;
            result += charPosition;
        }
        return result;
    }
}
