/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 20.2.2023 г.
 * Time: 5:28
 */
package P30ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputMessage = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.contains("Reveal")) {
            if (command.contains("InsertSpace")) {
                int index = Integer.parseInt(command.split(":\\|:")[1]);
                String newString = insertedString(inputMessage,index);
                inputMessage = newString;
                System.out.println(inputMessage);
            } else if (command.contains("Reverse")) {
                String substring = command.split(":\\|:")[1];
                List<Integer> numForCheck = new ArrayList<>();
                String revers = reversString(inputMessage,substring,numForCheck);
                inputMessage = revers;
                if (numForCheck.size() <= 0) {
                    System.out.println(inputMessage);
                }
            } else if (command.contains("ChangeAll")) {
                String oldString = command.split(":\\|:")[1];
                String newString = command.split(":\\|:")[2];
                String changedString = chageString(inputMessage,newString,oldString);
                inputMessage = changedString;
                System.out.println(inputMessage);
            }
            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n",inputMessage);
    }

    private static String chageString(String inputMessage, String newString, String oldString) {
        if (inputMessage.contains(oldString)) {
            inputMessage = inputMessage.replace(oldString,newString);
        }
        return inputMessage;
    }

    private static String reversString(String inputMessage, String substring, List<Integer> numForCheck) {
        StringBuilder builder = new StringBuilder(inputMessage);
        StringBuilder revers = new StringBuilder(substring);
        if (inputMessage.contains(substring)) {
            int startIndex = builder.indexOf(substring);
            int endIndex = startIndex + substring.length() - 1;
            builder.replace(startIndex,endIndex + 1,"");
            revers.reverse();
            builder.append(revers);
        } else {
            System.out.println("error");
            numForCheck.add(1);
        }
        return builder.toString();
    }

    private static String insertedString(String inputMessage, int index) {
        StringBuilder builder = new StringBuilder(inputMessage);
        builder.insert(index, " ");
        return builder.toString();
    }
}
