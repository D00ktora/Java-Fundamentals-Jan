package P08ExerciseArrays;

import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strArr = scanner.nextLine().split(" ");
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(String.valueOf(strArr[i]));
        }

        int counter = 0;
        boolean isDifferent = false;
        int startingIndex = 0;
        for (int i = 0; i < intArr.length; i++) {
            int temp = intArr[i];
            int tempCounter = 0;

            for (int j = i; j <= intArr.length - 1; j++) {
                if (temp == intArr[j]) {
                    tempCounter++;
                }else {
                    isDifferent = true;
                    break;
                }
            }

            if (tempCounter > counter) {
                counter = tempCounter;
                startingIndex = i;
            }

        }

        for (int i = startingIndex; i < counter + startingIndex; i++) {
            System.out.printf("%d ", intArr[i]);
        }
    }
}
