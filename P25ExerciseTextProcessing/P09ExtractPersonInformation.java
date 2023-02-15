/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 15.2.2023 г.
 * Time: 5:07
 */
package P25ExerciseTextProcessing;

import java.util.Scanner;

public class P09ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < iterations; i++) {
            String input = scanner.nextLine();
            int nameIndexStart = input.indexOf('@');
            int nameIndexEnd = input.indexOf('|');
            int ageIndexStart = input.indexOf('#');
            int ageIndexEnd = input.indexOf('*');
            String name = input.substring(nameIndexStart + 1, nameIndexEnd);
            String age = input.substring(ageIndexStart + 1, ageIndexEnd);

            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
