package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P08DivisibleBy3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //print all numbers that are divisible by 3
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
