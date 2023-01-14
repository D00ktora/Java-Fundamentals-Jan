package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P02Passed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read input
        double grade = Double.parseDouble(scanner.nextLine());

        //check if grade is greater than 3.00
        if (grade >= 3.00){
            System.out.println("Passed!");
        }
    }
}
