package P10Methods;

import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = Double.parseDouble(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double num2 = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.0f",(mathOperator(num1, operator, num2)));
    }

    private static double   mathOperator(double num1, char operator, double num2) {
        switch (operator) {
            case '/':
                return (num1 * 1.0) / (num2 * 1.0);
            case '*':
                return num1 * num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }
        return 0;
    }
}
