package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P07TheatrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        String typeOfTheDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        //price variable
        int price;

        //check age and time of the day and print corresponding price of the ticket
        switch (typeOfTheDay) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    price = 12;
                    System.out.printf("%d$%n", price);
                } else if (age > 18 && age <= 64) {
                    price = 18;
                    System.out.printf("%d$%n", price);
                } else if (age > 64 && age <= 122) {
                    price = 12;
                    System.out.printf("%d$%n", price);
                } else {
                    System.out.println("Error!");
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    price = 15;
                    System.out.printf("%d$%n", price);
                } else if (age > 18 && age <= 64) {
                    price = 20;
                    System.out.printf("%d$%n", price);
                } else if (age > 64 && age <= 122) {
                    price = 15;
                    System.out.printf("%d$%n", price);
                } else {
                    System.out.println("Error!");
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    price = 5;
                    System.out.printf("%d$%n", price);
                } else if (age > 18 && age <= 64) {
                    price = 12;
                    System.out.printf("%d$%n", price);
                } else if (age > 64 && age <= 122) {
                    price = 10;
                    System.out.printf("%d$%n", price);
                } else {
                    System.out.println("Error!");
                }
                break;
            default:
                System.out.println("Error!");
                break;
        }
    }
}
