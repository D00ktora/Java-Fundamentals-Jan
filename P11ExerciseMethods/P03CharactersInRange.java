package P11ExerciseMethods;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char character1 = scanner.nextLine().charAt(0);
        char character2 = scanner.nextLine().charAt(0);

        printCharacters(character1, character2);
    }

    private static void printCharacters(char character1, char character2) {
        if (character1 > character2) {
            char temp = character1;
            character1 = character2;
            character2 = temp;
        }
        for (int i = character1 + 1; i <= character2 - 1; i++) {
            char newChar = (char) i;
            System.out.printf("%c ", newChar);
        }
    }
}
