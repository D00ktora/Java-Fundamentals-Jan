package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P16DecryptingMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int increment = Integer.parseInt(scanner.nextLine());
        int numberOfCharecters = Integer.parseInt(scanner.nextLine());
        String result = "";

        for (int i = 0; i < numberOfCharecters; i++) {

            char input = scanner.nextLine().charAt(0);
            input += increment;
            result += input;
        }
        System.out.println(result);
    }
}
