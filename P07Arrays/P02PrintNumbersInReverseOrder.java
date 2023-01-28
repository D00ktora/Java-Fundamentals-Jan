package P07Arrays;

import java.util.Scanner;

public class P02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfArr = Integer.parseInt(scanner.nextLine());

        int[] arrInt = new int[sizeOfArr];

        for (int i = 0; i < arrInt.length; i++) {
            int temp = Integer.parseInt(scanner.nextLine());
            arrInt[i] = temp;
        }
        for (int i = arrInt.length - 1; i >= 0; i--) {
            System.out.printf("%d ",arrInt[i]);
        }
    }
}
