package P07Arrays;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrStr = scanner.nextLine().split(" ");
        String tempStr = "";
        int iterations = arrStr.length / 2;

        for (int i = 0; i < iterations; i++) {
            String temp = arrStr[i];
            arrStr[i] = arrStr[arrStr.length - 1 - i];
            arrStr[arrStr.length - 1 - i] = temp;
        }

        for (int i = 0; i < arrStr.length; i++) {
            System.out.printf("%s ", arrStr[i]);
        }
    }
}
