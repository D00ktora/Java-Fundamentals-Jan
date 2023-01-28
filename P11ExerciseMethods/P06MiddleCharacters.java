package P11ExerciseMethods;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleCharacters(input);
    }

    private static void printMiddleCharacters(String input) {
        if (input.length() % 2 == 0){
            int start = (input.length() / 2) - 1;
            for (int i = start; i <= start+1; i++) {
                System.out.printf("%s",input.charAt(i));
            }
        }else {
            int start = (input.length() / 2) - 1;
            System.out.println(input.charAt(start + 1));
        }
    }
}
