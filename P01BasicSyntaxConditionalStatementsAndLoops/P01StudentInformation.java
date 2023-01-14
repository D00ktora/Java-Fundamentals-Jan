package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P01StudentInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        String studentName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double grade = Double.parseDouble(scanner.nextLine());

        //print
        System.out.printf("Name: %s, Age: %d, Grade: %.2f",studentName,age,grade);
    }
}
