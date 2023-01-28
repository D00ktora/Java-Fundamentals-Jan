package P10Methods;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        double number1 = Integer.parseInt(scanner.nextLine());
        double number2 = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                add(number1, number2);
                break;
            case "multiply":
                multiply(number1, number2);
                break;
            case "subtract":
                subtract(number1, number2);
                break;
            case "divide":
                divide(number1, number2);
        }
    }

    private static void divide(double number1, double number2) {
        double sum = number1 / number2;
        System.out.printf("%.0f",sum);
    }

    private static void subtract(double number1, double number2) {
        double sum = number1 - number2;
        System.out.printf("%.0f", sum);
    }

    private static void multiply(double number1, double number2) {
        double sum = number1 * number2;
        System.out.printf("%.0f", sum);
    }

    private static void add(double number1, double number2) {
        double sum = number1 + number2;
        System.out.printf("%.0f", sum);
    }
}
