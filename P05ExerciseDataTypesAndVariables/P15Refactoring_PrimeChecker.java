package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P15Refactoring_PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= endNumber; i++) {
            boolean isItPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isItPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isItPrime);
        }
    }
}
