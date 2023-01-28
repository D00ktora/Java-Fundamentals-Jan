package P07Arrays;

import java.util.Scanner;

public class P07CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrStr = scanner.nextLine().split(" ");

        while (arrStr.length > 1) {
            String[] arrSum = new String[arrStr.length - 1];

            for (int i = 0; i < arrStr.length - 1; i++) {

                int temp1 = Integer.parseInt(String.valueOf(arrStr[i]));
                int temp2 = Integer.parseInt(String.valueOf(arrStr[i + 1]));

                arrSum[i] = String.valueOf(temp1 + temp2);
            }
            arrStr = arrSum;
        }

        System.out.println(arrStr[0]);
    }
}
