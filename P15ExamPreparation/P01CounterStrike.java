/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 5:56
 */
package P15ExamPreparation;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int winBattles = 0;
        int totalWinBattles = 0;
        while (!input.contains("End of battle")) {
            int distance = Integer.parseInt(input);
            if (initialEnergy - distance >= 0) {
                initialEnergy -= distance;
                winBattles++;
                totalWinBattles++;
                if (winBattles == 3) {
                    initialEnergy += totalWinBattles;
                    winBattles = 0;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",totalWinBattles, initialEnergy);
                return;
            }
            input = scanner.nextLine();
        }
            System.out.printf("Won battles: %d. Energy left: %d",totalWinBattles, initialEnergy);
    }
}
