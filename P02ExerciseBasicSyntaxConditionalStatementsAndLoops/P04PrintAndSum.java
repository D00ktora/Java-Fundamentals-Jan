package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P04PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        int from = Integer.parseInt(scanner.nextLine());
        int to = Integer.parseInt(scanner.nextLine());

        for (int i = from; i <= to; i++){
            System.out.printf("%d ",i);
            sum += i;
        }
        System.out.printf("%nSum: %d%n",sum);
    }
}
