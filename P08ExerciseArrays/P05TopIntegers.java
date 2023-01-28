package P08ExerciseArrays;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] temp = scanner.nextLine().split(" ");
        int[] arrInt = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            int tempInt = Integer.parseInt(String.valueOf(temp[i]));
            arrInt[i] = tempInt;
        }

        if (arrInt.length > 1) {
            for (int i = 0; i < arrInt.length - 1; i++) {
                int tempInt = arrInt[i];
                boolean isAllLower = true;
                for (int j = i + 1; j <= arrInt.length - 1; j++) {
                    int tempInt2 = arrInt[j];
                    if (tempInt > arrInt[j]) {
                        isAllLower = true;
                    } else {
                        isAllLower = false;
                        break;
                    }
                }
                if (isAllLower) {
                    System.out.printf("%d ", tempInt);
                }
            }
        } else {
            System.out.printf("%d", arrInt[0]);
        }
        System.out.println(arrInt[arrInt.length - 1]);
    }
}
