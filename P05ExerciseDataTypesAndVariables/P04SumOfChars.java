package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P04SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iteration = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < iteration; i++) {
            char charecter = scanner.nextLine().charAt(0);
            sum += charecter;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
