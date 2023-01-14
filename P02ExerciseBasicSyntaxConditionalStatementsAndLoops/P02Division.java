package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Iterator;
import java.util.Scanner;

public class P02Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number % 10 == 0){
            System.out.printf("The number is divisible by %d%n", 10);
        } else if (number % 7 == 0) {
            System.out.printf("The number is divisible by %d%n", 7);
        } else if (number % 6 == 0) {
            System.out.printf("The number is divisible by %d%n", 6);
        } else if (number % 3 == 0) {
            System.out.printf("The number is divisible by %d%n", 3);
        } else if (number % 2 == 0) {
            System.out.printf("The number is divisible by %d%n", 2);
        }else {
            System.out.println("Not divisible");
        }
    }
}
