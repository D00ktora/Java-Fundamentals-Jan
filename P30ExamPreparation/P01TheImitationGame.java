/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.2.2023 г.
 * Time: 21:06
 */
package P30ExamPreparation;

import java.util.Scanner;

public class P01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            if (input.contains("Move")) {
                String movedWord = move(input, message);
                message = movedWord;
            } else if (input.contains("Insert")) {
                String insertedWord = insert(input, message);
                message = insertedWord;
            } else if (input.contains("ChangeAll")) {
                String changedWord = changeWord(input, message);
                message = changedWord;
            }
            input = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s",message);
    }

    private static String changeWord(String input, String message) {
        String changeString = input.split("[|]")[1];
        String replacement = input.split("[|]")[2];
        message = message.replace(changeString,replacement);
        return message;
    }

    private static String insert(String input, String message) {
        int index = Integer.parseInt(input.split("[|]")[1]);
        String value = input.split("[|]")[2];
        StringBuilder temp = new StringBuilder(message);
        temp.insert(index,value);
        return temp.toString();
    }

    private static String move(String input, String massage) {
        int number = Integer.parseInt(input.split("[|]")[1]);
        String substringOfInput = massage.substring(0,number);
        massage = massage.replace(substringOfInput,"");
        massage = massage += substringOfInput;
        return massage;
    }
}
