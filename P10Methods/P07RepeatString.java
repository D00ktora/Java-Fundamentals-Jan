package P10Methods;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int times = Integer.parseInt(scanner.nextLine());

        String repeatedString = createRepeatedString(string, times);
        System.out.println(repeatedString);
    }

    private static String createRepeatedString(String string, int times) {
        String newString = "";
        for (int i = 0; i < times; i++) {
            newString += string;
        }
        return newString;
    }
}
