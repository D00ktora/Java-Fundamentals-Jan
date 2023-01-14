package P04DataTypesAndVariables;

import java.util.Scanner;

public class P02PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());
        double toDollar = input * 1.36;

        System.out.printf("%.3f",toDollar);
    }
}
