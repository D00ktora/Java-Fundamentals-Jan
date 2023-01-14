package P04DataTypesAndVariables;

import java.util.Scanner;

public class P12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int howMany = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int temp = 0;
        boolean isSpecial = false;
        for (int i = 1; i <= howMany; i++) {
            temp = i;
            while (i > 0) {
                sum += i % 10;
                i = i / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecial) {
                System.out.printf("%d -> True%n", temp);
            }else {
                System.out.printf("%d -> False%n", temp);
            }
            sum = 0;
            i = temp;
        }
    }
}
