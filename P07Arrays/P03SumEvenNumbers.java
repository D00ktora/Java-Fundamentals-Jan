package P07Arrays;

import java.sql.Array;
import java.util.Scanner;

public class P03SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrStr = scanner.nextLine().split(" ");
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < arrStr.length; i++) {
            int temp = Integer.parseInt(String.valueOf(arrStr[i]));
            if (temp % 2 == 0) {
                sumEven += temp;
            }
        }

        System.out.println(sumEven);
    }
}
