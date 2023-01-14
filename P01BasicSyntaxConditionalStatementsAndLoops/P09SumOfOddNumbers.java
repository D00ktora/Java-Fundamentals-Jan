package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //input
        int number = Integer.parseInt(scanner.nextLine());

        //variables for output
        int sum = 0;
        int num = 1;

        System.out.println(num);
        sum += num;

        //calculate the sum
        for (int i = 0; i < number - 1; i++) {
            num += 2;
            System.out.println(num);
            sum += num;
        }

        System.out.printf("Sum: %d%n",sum);
    }
}
