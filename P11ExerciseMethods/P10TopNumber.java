package P11ExerciseMethods;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            boolean isDevisible = isTheSumDevisibleBy8(i);
            boolean isOdd = isOddNumberInside(i);

            if (isOdd && isDevisible) {
                System.out.println(i);
            }
        }


    }

    private static boolean isOddNumberInside(int number) {
        int sum = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }

        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }
//isTheSumDevisibleBy8
    private static boolean isTheSumDevisibleBy8(int number) {
        while (number != 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
