package P08ExerciseArrays;

import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrStr = scanner.nextLine().split(" ");
        int iterations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < iterations; i++) {

            String[] temp = new String[arrStr.length];
            String tempString = arrStr[0];

            for (int j = 0; j < arrStr.length - 1; j++) {
                temp[j] = arrStr[j+1];
            }

            temp[arrStr.length-1] = tempString;
            arrStr = temp;
        }

        for (int i = 0; i < arrStr.length; i++) {
            System.out.printf("%s ", arrStr[i]);
        };
    }
}
