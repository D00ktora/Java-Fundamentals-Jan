package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        int number = Integer.parseInt(scanner.nextLine());

        //process for-cycle and print
        for (int i = 1; i <= 10; i++) {
            int product = number * i;
            System.out.printf("%d X %d = %d%n",number,i,product);
        }
    }
}
