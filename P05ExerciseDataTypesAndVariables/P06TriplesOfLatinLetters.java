package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());;


        for (int i = 0; i < input; i++) {
            char first = (char) ('a' + i);
            for (int j = 0; j < input; j++) {
                char second = (char) ('a' + j);
                for (int k = 0; k < input; k++) {
                    char third = (char) ('a' + k);
                    System.out.printf("%s%s%s%n", first, second, third);
                }
            }
        }
    }
}
