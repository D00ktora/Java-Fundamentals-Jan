package P11ExerciseMethods;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        isPasswordValid(input);
    }

    private static void isPasswordValid(String input) {
        boolean isBetween6and10 = false;
        boolean isOnlyLetersAndDigits = false;
        boolean isthereMoreThen2Dighits = false;
        if (input.length() >= 6 && input.length() <= 10){
            isBetween6and10 = true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
        }

        int digitCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') || (input.charAt(i) >= '0' && input.charAt(i) <= '9')){
                isOnlyLetersAndDigits = true;
            } else {
                System.out.println("Password must consist only of letters and digits");
                isOnlyLetersAndDigits = false;
                break;
            }
        }

        for (int i = 0; i < input.length(); i++) {
            if (((input.charAt(i) >= '0') && (input.charAt(i) <= '9'))) {
                digitCounter++;
            }
        }

        if (digitCounter >= 2) {
            isthereMoreThen2Dighits = true;
        }else {
            System.out.println("Password must have at least 2 digits");
        }

        if (isOnlyLetersAndDigits && isBetween6and10 && isthereMoreThen2Dighits) {
            System.out.println("Password is valid");
        }
    }
}
