package P11ExerciseMethods;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        VowelsCount(input);
    }

    private static void VowelsCount(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            if (
            input.charAt(i) == 'A' ||
            input.charAt(i) == 'a' ||
            input.charAt(i) == 'E' ||
            input.charAt(i) == 'e' ||
            input.charAt(i) == 'o' ||
            input.charAt(i) == 'O' ||
            input.charAt(i) == 'u' ||
            input.charAt(i) == 'U' ||
            input.charAt(i) == 'i' ||
            input.charAt(i) == 'I') {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
