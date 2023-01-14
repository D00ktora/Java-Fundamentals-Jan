package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P13EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        String input = scanner.nextLine();
        int index = input.length() - 1;
        String lastNumber = "";
        lastNumber += lastNumber + input.charAt(index);
        int number = Integer.parseInt(lastNumber);

        if (number == 1) {
            System.out.println("one");
        } else if (number == 2) {
            System.out.println("two");
        } else if (number == 3) {
            System.out.println("three");
        } else if (number == 4) {
            System.out.println("four");
        } else if (number == 5) {
            System.out.println("five");
        } else if (number == 6) {
            System.out.println("six");
        } else if (number == 7) {
            System.out.println("seven");
        } else if (number == 8) {
            System.out.println("eight");
        } else if (number == 9) {
            System.out.println("nine");
        } else if (number == 0) {
            System.out.println("zero");
        }
    }
}
