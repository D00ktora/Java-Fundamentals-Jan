/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 15:23
 */
package P16ExamPreparation2;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeEfficiency1 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency2 = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency3 = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int questionsPerHour = calculateQPR(employeeEfficiency1,employeeEfficiency2,employeeEfficiency3);
        double numberOfHoursNeed = numberOfHN(studentsCount, questionsPerHour);
        double numberOfBreaks = numBreaks(numberOfHoursNeed);
        double result = numberOfBreaks + numberOfHoursNeed;
        if (result < 0 ){
            result = 0;
        }
        System.out.printf("Time needed: %.0fh.",result);
    }

    private static double numBreaks(double numberOfHoursNeed) {
        if (numberOfHoursNeed % 3 == 0){
            return numberOfHoursNeed / 3 - 1;
        }
        return Math.floor(numberOfHoursNeed / 3.0);
    }

    private static double numberOfHN(int studentsCount, int questionsPerHour) {
        return Math.ceil(studentsCount * 1.0 / questionsPerHour);
    }

    private static int calculateQPR(int employeeEfficiency1, int employeeEfficiency2, int employeeEfficiency3) {
        return employeeEfficiency1 + employeeEfficiency2 + employeeEfficiency3;
    }
}
