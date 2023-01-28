package P10Methods;

import java.util.Scanner;

public class P06CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());

        double sum = calculateArea(num1, num2);
        System.out.printf("%.0f",sum);
    }

    private static double calculateArea(double num1, double num2) {
        double sum = num1 * num2;
        return sum;
    }
}
