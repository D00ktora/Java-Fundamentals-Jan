package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0.00;

        while (!input.equals("Start")) {
            double temp = Double.parseDouble(input);
            if (temp == 0.1 || temp == 0.2 || temp == 0.5 || temp == 1 || temp == 2) {
                totalMoney += Double.parseDouble(input);
            }else {
                System.out.printf("Cannot accept %.2f%n",temp);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            if (input.equals("Nuts")) {
                Boolean isAvailabelCoins = totalMoney >= 2.0;
                if (isAvailabelCoins) {
                    System.out.printf("Purchased %s%n", input);
                    totalMoney -= 2.0;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Water")) {
                Boolean isAvailabelCoins = totalMoney >= 0.7;
                if (isAvailabelCoins) {
                    System.out.printf("Purchased %s%n", input);
                    totalMoney -= 0.7;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Crisps")) {
                Boolean isAvailabelCoins = totalMoney >= 1.5;
                if (isAvailabelCoins) {
                    System.out.printf("Purchased %s%n", input);
                    totalMoney -= 1.5;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Soda")) {
                Boolean isAvailabelCoins = totalMoney >= 0.8;
                if (isAvailabelCoins) {
                    System.out.printf("Purchased %s%n", input);
                    totalMoney -= 0.8;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Coke")) {
                Boolean isAvailabelCoins = totalMoney >= 1.0;
                if (isAvailabelCoins) {
                    System.out.printf("Purchased %s%n", input);
                    totalMoney -= 1.0;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else {
                System.out.println("Invalid product");
            }
            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f",totalMoney);
    }
}
