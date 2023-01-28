package P08ExerciseArrays;

import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strArr = scanner.nextLine().split(" ");
        int[] arr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(strArr[i]));
        }


        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {

            int sumArr1 = 0;
            int sumArr2 = 0;
            int[] tempArr1 = new int[i];
            int[] tempArr2 = new int[arr.length - 1 - i];

            if (tempArr1.length > 0) {
                for (int j = 0; j < tempArr1.length; j++) {
                    tempArr1[j] = arr[j];
                    sumArr1 += tempArr1[j];
                }
            }

            if (tempArr2.length > 0) {
                for (int j = 0; j < tempArr2.length; j++) {
                    tempArr2[j] = arr[i+j+1];
                    sumArr2 += tempArr2[j];
                }
            }
            
            if (sumArr1 == sumArr2) {
                System.out.println(i);
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("no");
        }
    }
}
