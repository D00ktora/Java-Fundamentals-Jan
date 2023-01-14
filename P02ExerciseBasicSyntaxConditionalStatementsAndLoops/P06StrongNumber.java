package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        int sum = 0;
        int numberAsInt = Integer.parseInt(number);

        for (int i = 0; i < number.length(); i++) {
            int factorial = Integer.parseInt(String.valueOf(number.charAt(i)));
            int tempSum = factorial;
            for (int j = factorial - 1; j >= 1; j--) {
                tempSum *= j;
            }
            sum += tempSum;
        }

        if (sum == numberAsInt){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
