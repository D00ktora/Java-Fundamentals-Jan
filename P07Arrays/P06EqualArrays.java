package P07Arrays;

import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isEqual = false;
        int index = 0;
        String[] arr1 = scanner.nextLine().split(" ");
        String[] arr2 = scanner.nextLine().split(" ");
        int sum = 0;
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].equals(arr2[i])) {
                    index = i;
                    break;
                }
                int temp = Integer.parseInt(String.valueOf(arr1[i]));
                sum += temp;
                if (i == arr1.length - 1) {
                    isEqual = true;
                }
            }
        }

        if (isEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }
    }
}
