/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 18:36
 */
package P16ExamPreparation2;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        int maxAttendances = 0;
        double maxBonus = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            double bonus = attendances * 1.0 / lectures * (5 + additionalBonus);
            if (bonus > maxBonus) {
                maxBonus = bonus;
                maxAttendances = attendances;
            }
        }
        maxBonus = Math.ceil(maxBonus);
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}
