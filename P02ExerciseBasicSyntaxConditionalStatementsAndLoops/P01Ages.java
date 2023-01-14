package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class P01Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number >= 0 && number <= 2) {
            System.out.println("baby");
        } else if (number > 2 && number <= 13) {
            System.out.println("child");
        } else if (number > 13 && number <= 19) {
            System.out.println("teenager");
        } else if (number > 19 && number <= 65) {
            System.out.println("adult");
        } else if (number >= 66){
            System.out.println("elder");
        }
    }
}
