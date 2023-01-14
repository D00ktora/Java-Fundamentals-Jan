package P05ExerciseDataTypesAndVariables;

import java.util.Calendar;
import java.util.Scanner;

public class P05PrintPartOfTheASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (int i = start; i <= end; i++) {
            char temp = (char) i;
            System.out.printf("%s ", temp);
        }
    }
}
