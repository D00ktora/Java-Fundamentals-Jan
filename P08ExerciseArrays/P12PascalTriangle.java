package P08ExerciseArrays;

import java.util.Scanner;

public class P12PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        int[] endArr = new int[input];

        for (int i = 0; i < endArr.length; i++) {
            endArr[i] = 0;
        }
        endArr[0] = 1;
        for (int i = 0; i < input + 1; i++) {
            int[] temp = new int[i + 1];
            temp[0] = 1;
            for (int j = 1; j < temp.length - 1; j++) {
                if (temp[j - 1] + temp[j] != 0) {
                    temp[j] = endArr[j - 1] + endArr[j];
                } else {
                    break;
                }
            }
            endArr = temp;

            if (i != 0) {
                for (int j = 0; j < endArr.length; j++) {
                    if (endArr[j] != 0) {
                        System.out.printf("%d ", endArr[j]);
                    }
                }
                System.out.println();
            }
        }
    }
}
