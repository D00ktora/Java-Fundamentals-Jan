package P11ExerciseMethods;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();


        while (!text.equals("END")) {
            boolean isPalindrom = false;
            isPalindrom = isOK(text);
            if (isPalindrom) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            text = scanner.nextLine();
        }
    }
    public static boolean isOK (String text) {
        String temp = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            temp += text.charAt(i);
        }

        if (temp.equals(text))
        {
            return true;
        }
        return false;
    }
}
