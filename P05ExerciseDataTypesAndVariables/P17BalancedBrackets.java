package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P17BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRuns = Integer.parseInt(scanner.nextLine());
        int bracketOpen = 0;
        boolean flagForOpen = false;
        int bracketClosed = 0;
        boolean flagForClose = false;
        boolean finalFlag = false;
        for (int i = 0; i < numberOfRuns; i++) {
            String input = scanner.nextLine();
            if (input.charAt(0) == '(') {
                bracketOpen++;
                if (flagForOpen) {
                    System.out.println("UNBALANCED");
                    finalFlag = true;
                    break;
                }
                flagForOpen = true;
                flagForClose = false;
            } else if (input.charAt(0) == ')') {
                bracketClosed++;
                if (flagForClose) {
                    System.out.println("UNBALANCED");
                    finalFlag = true;
                    break;
                }
                flagForOpen = false;
                flagForClose = true;
            }
        }
        if (bracketOpen == bracketClosed) {
            System.out.println("BALANCED");
        } else if (!finalFlag) {
            System.out.println("UNBALANCED");
        }
    }
}
