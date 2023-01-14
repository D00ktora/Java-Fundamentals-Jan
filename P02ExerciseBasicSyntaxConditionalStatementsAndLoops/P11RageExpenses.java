package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int crashedHeadsets = 0;
        int crashedMouses = 0;
        int crashedKeyboards = 0;
        int crashedDisplays = 0;
        int crashedKeyboardsTep = 0;

        double totalSum = 0.0;

        for (int i = 1; i <= lostGames; i++) {
            Boolean crashedMouse = false;
            Boolean crashedHeadset = false;
            Boolean crashedKeyboard = false;
            if (i % 3 == 0) {
                crashedMouses++;
                crashedMouse = true;
                totalSum += mousePrice;
            }
            if (i % 2 == 0) {
                crashedHeadsets++;
                crashedHeadset = true;
                totalSum += headsetPrice;
            }
            if (crashedHeadset && crashedMouse) {
                crashedKeyboards++;
                if (crashedKeyboards % 2 == 0) {
                    crashedKeyboard = true;
                }
                totalSum += keyboardPrice;
            }
            if (crashedKeyboard) {
                crashedDisplays++;
                totalSum += displayPrice;
            }
        }

        System.out.printf("Rage expenses: %.2f lv.", totalSum);
    }
}
