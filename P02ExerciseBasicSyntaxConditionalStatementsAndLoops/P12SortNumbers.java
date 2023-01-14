package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Arrays;
import java.util.Scanner;

public class P12SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        int [] array = new int [3];
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        array[0] = number1;
        array[1] = number2;
        array[2] = number3;

        Arrays.sort(array);

        int temp = array[2];
        array[2] = array[0];
        array[0] = temp;

        for (int i = 0; i< array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
