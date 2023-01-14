package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P11MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        int number = Integer.parseInt(scanner.nextLine());
        int start = Integer.parseInt(scanner.nextLine());

        //process for-cycle and print
        if (start <= 10 && start >=1) {
            for (int i = start; i <= 10; i++) {
                int product = number * i;
                System.out.printf("%d X %d = %d%n", number, i, product);
            }
        } else {
            int product = start * number;
            System.out.printf("%d X %d = %d%n", number, start, product);
        }
    }
}
