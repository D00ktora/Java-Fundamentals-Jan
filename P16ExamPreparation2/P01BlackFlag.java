/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 8:46
 */
package P16ExamPreparation2;

import java.util.Scanner;

public class P01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double additionalPlunder = dailyPlunder / 2;
        int threeDays = days / 3;
        int fiveDays = days / 5;
        double plunder = 0;
        for (int i = 1; i <= days; i++) {
            plunder += dailyPlunder;
            if (i % 3 == 0) {
                plunder += dailyPlunder / 2.0;
            }
            if (i % 5  == 0) {
                plunder *= 0.7;
            }
        }

        if (plunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", plunder);
        } else {
            double percentageLeft = plunder / expectedPlunder * 100.0;
            System.out.printf("Collected only %.2f%% of the plunder.", percentageLeft);
        }
    }
}
