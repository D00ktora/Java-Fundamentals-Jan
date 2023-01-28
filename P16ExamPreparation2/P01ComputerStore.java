/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 14:49
 */
package P16ExamPreparation2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> prices = new ArrayList<>();
        String input = scanner.nextLine();
        while (true) {
            if (input.contains("special") || input.contains("regular")) {
                break;
            }
            double tempPrice = Double.parseDouble(input);
            prices.add(tempPrice);
            input = scanner.nextLine();

        }
        double taxes = calculateTaxes(prices);
        double sum = calculateSum(prices);
        double discount = calculateDiscount(taxes,sum, input);
        double totalWithTaxes = sum + taxes - discount;
        printOnConsole(totalWithTaxes,taxes,sum);
    }

    private static void printOnConsole(double totalWithTaxes, double taxes, double sum) {
        if (totalWithTaxes > 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sum);
            System.out.printf("Taxes: %.2f$%n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",totalWithTaxes);
        } if (totalWithTaxes <= 0) {
            System.out.println("Invalid order!");
        }
    }

    private static double calculateDiscount(double taxes, double sum, String input) {
        double temp = 0;
        if (input.contains("special")) {
            temp = (taxes+sum) * 0.1;
        }
        return temp;
    }

    private static double calculateSum(List<Double> prices) {
        double sum = 0;
        for (Double price : prices) {
            if (price >= 0) {
                sum += price;
            }
        }
        return sum;
    }

    private static double calculateTaxes(List<Double> prices) {
        double sum = 0;
        for (Double price : prices) {
            if (price >= 0) {
                sum += price;
            } else {
                System.out.println("Invalid price!");
            }
        }
        return sum * 0.2;
    }
}
