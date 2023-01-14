package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P14FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());

        if (firstNum > secondNum) {
            if (firstNum - secondNum <= 0.000001) {
                System.out.println("True");
            }else {
                System.out.println("False");
            }
        } else if (secondNum > firstNum) {
            if (secondNum - firstNum <= 0.000001) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
