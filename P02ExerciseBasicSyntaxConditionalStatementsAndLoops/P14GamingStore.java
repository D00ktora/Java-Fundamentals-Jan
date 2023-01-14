package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P14GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double capital = Double.parseDouble(scanner.nextLine());

        String input = scanner.nextLine();
        double sumOfGames = 0.0;
        while (!input.equals("Game Time")) {
            if (input.equals("OutFall 4")) {
                double temp = capital;
                if (temp >= 39.99) {
                    System.out.println("Bought OutFall 4");
                    capital -= 39.99;
                    sumOfGames += 39.99;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("CS: OG")) {
                double temp = capital;
                if (temp >= 15.99) {
                    System.out.println("Bought CS: OG");
                    capital -= 15.99;
                    sumOfGames += 15.99;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("Zplinter Zell")) {
                double temp = capital;
                if (temp >= 19.99) {
                    System.out.println("Bought Zplinter Zell");
                    capital -= 19.99;
                    sumOfGames += 19.99;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("Honored 2")) {
                double temp = capital;
                if (temp >= 59.99) {
                    System.out.println("Bought Honored 2");
                    capital -= 59.99;
                    sumOfGames += 59.99;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("RoverWatch")) {
                double temp = capital;
                if (temp >= 29.99) {
                    System.out.println("Bought RoverWatch");
                    capital -= 29.99;
                    sumOfGames += 29.99;
                } else {
                    System.out.println("Too Expensive");
                }
            } else if (input.equals("RoverWatch Origins Edition")) {
                double temp = capital;
                if (temp >= 39.99) {
                    System.out.println("Bought RoverWatch Origins Edition");
                    capital -= 39.99;
                    sumOfGames += 39.99;
                } else {
                    System.out.println("Too Expensive");
                }
            }else {
                System.out.println("Not Found");
            }

            if (capital == 0) {
                System.out.println("Out of money!");
                break;
            }
            input = scanner.nextLine();
        }

        if (capital > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", sumOfGames, capital);
        }
    }
}
