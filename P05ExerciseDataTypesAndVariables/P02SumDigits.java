package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < input.length(); i++){
            String integerValue = String.valueOf(input.charAt(i));
            int temp = Integer.parseInt(String.valueOf(integerValue));
            sum += temp;
        }
        System.out.println(sum);
    }
}
