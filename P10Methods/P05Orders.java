package P10Methods;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        CalculatePrice(product,quantity);
    }

    private static void CalculatePrice(String product, int quantity) {
        switch (product) {
            case "coffee":
                double priceCoffee = quantity * 1.50;
                System.out.printf("%.2f", priceCoffee);
                break;
            case "water":
                double priceWater = quantity * 1.00;
                System.out.printf("%.2f", priceWater);
                break;
            case "coke":
                double priceCoke = quantity * 1.40;
                System.out.printf("%.2f", priceCoke);
                break;
            case "snacks":
                double priceSnacks = quantity * 2.00;
                System.out.printf("%.2f", priceSnacks);
                break;
        }
    }
}
