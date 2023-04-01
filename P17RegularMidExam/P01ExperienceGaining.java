/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.2.2023 г.
 * Time: 7:11
 */
package P17RegularMidExam;

import java.util.Scanner;

public class P01ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double expirianceNeeded = Double.parseDouble(scanner.nextLine());
        int battleCount = Integer.parseInt(scanner.nextLine());
        double collectedExiriance = 0;
        for (int i = 1; i <= battleCount; i++) {
            double expiriance = Double.parseDouble(scanner.nextLine());
            if (i % 3 == 0) {
                expiriance *= 1.15;
            }
            if (i % 5 == 0) {
                expiriance *= 0.9;
            }
            if (i % 15 == 0) {
                expiriance *= 1.05;
            }
            collectedExiriance += expiriance;
            if (collectedExiriance >= expirianceNeeded) {
                System.out.printf("Player successfully collected his needed experience for %d battles.%n",i);
                return;
            }
        }

        if (collectedExiriance >= expirianceNeeded) {
            System.out.printf("Player successfully collected his needed experience for %d battles.%n",battleCount);
            return;
        } else if (collectedExiriance < expirianceNeeded) {
            double result = expirianceNeeded - collectedExiriance;
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.%n",result);
        }
    }
}
