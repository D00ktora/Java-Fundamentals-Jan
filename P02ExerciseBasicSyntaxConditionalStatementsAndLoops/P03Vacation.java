package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        String typeOfTheGroup = scanner.nextLine();
        String dayOfTheWeek = scanner.nextLine();

        Boolean isTheStudentsGroupMoreThen30 = numberOfStudents >= 30;
        Boolean isTheBusinessGroupMoreThen100 = numberOfStudents >= 100;
        Boolean isTheRegularGroupMoreThen10AndLessThen20 = numberOfStudents >= 10 && numberOfStudents <= 20;
        double totalSum = 0;

        switch (typeOfTheGroup){
            case "Students":

                if (dayOfTheWeek.equals("Friday")) {
                    totalSum = 8.45 * numberOfStudents;
                    if (isTheStudentsGroupMoreThen30) {
                        totalSum *= 0.85;
                    }
                } else if (dayOfTheWeek.equals("Saturday")) {
                    totalSum = 9.80 * numberOfStudents;
                    if (isTheStudentsGroupMoreThen30) {
                        totalSum *= 0.85;
                    }
                } else if (dayOfTheWeek.equals("Sunday")) {
                    totalSum = 10.46 * numberOfStudents;
                    if (isTheStudentsGroupMoreThen30) {
                        totalSum *= 0.85;
                    }
                }
                break;

            case "Business":

                if (dayOfTheWeek.equals("Friday")) {
                    if (isTheBusinessGroupMoreThen100) {
                        numberOfStudents -= 10;
                        totalSum = 10.90 * numberOfStudents;
                    }else {
                        totalSum = 10.90 * numberOfStudents;
                    }
                } else if (dayOfTheWeek.equals("Saturday")) {
                    if (isTheBusinessGroupMoreThen100) {
                        numberOfStudents -= 10;
                        totalSum = 15.60 * numberOfStudents;
                    }else {
                        totalSum = 15.60 * numberOfStudents;
                    }
                } else if (dayOfTheWeek.equals("Sunday")) {
                    if (isTheBusinessGroupMoreThen100) {
                        numberOfStudents -= 10;
                        totalSum = 16.00 * numberOfStudents;
                    }else {
                        totalSum = 16.00 * numberOfStudents;
                    }
                }
                break;

            case "Regular":

                if (dayOfTheWeek.equals("Friday")) {
                    totalSum = 15.00 * numberOfStudents;
                    if (isTheRegularGroupMoreThen10AndLessThen20) {
                        totalSum *= 0.95;
                    }
                } else if (dayOfTheWeek.equals("Saturday")) {
                    totalSum = 20.00 * numberOfStudents;
                    if (isTheRegularGroupMoreThen10AndLessThen20) {
                        totalSum *= 0.95;
                    }
                } else if (dayOfTheWeek.equals("Sunday")) {
                    totalSum = 22.50 * numberOfStudents;
                    if (isTheRegularGroupMoreThen10AndLessThen20) {
                        totalSum *= 0.95;
                    }
                }
                break;
        }

        System.out.printf("Total price: %.2f",totalSum);
    }
}
