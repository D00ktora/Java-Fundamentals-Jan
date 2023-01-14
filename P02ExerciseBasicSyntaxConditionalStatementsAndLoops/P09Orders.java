package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        double totalSum = 0.0;

        for (int i = 0; i< number; i++) {
            double price = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsule = Integer.parseInt(scanner.nextLine());
            double totalPrice = ((days * capsule) * price);
            totalSum += totalPrice;
            System.out.printf("The price for the coffee is: $%.2f%n", totalPrice);
        }

        System.out.printf("Total: $%.2f%n", totalSum);
    }
}
