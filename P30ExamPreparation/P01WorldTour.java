/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.2.2023 г.
 * Time: 13:52
 */
package P30ExamPreparation;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.contains("Travel")) {
            if (command.contains("Add")) {
                int index = Integer.parseInt(command.split(":")[1]);
                String location = command.split(":")[2];
                if (indexIsValid(index,inputLine)){
                    String newString = addAtIndex(inputLine,location, index);
                    inputLine = newString;
                    System.out.println(inputLine);
                } else {
                    System.out.println(inputLine);
                }
            } else if (command.contains("Remove")) {
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);
                if (indexIsValid(startIndex, inputLine) && indexIsValid(endIndex, inputLine)) {
                    String newString = removeString(startIndex,endIndex,inputLine);
                    inputLine = newString;
                    System.out.println(inputLine);
                } else {
                    System.out.println(inputLine);
                }
            } else if (command.contains("Switch")) {
                String oldString = command.split(":")[1];
                String newString = command.split(":")[2];
                if (inputLine.contains(oldString)) {
                    inputLine = inputLine.replace(oldString,newString);
                    System.out.println(inputLine);
                } else {
                    System.out.println(inputLine);
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s",inputLine);
    }

    private static String removeString(int startIndex, int endIndex, String inputLine) {
        StringBuilder builder = new StringBuilder(inputLine);
        builder.replace(startIndex, endIndex + 1,"");
        return builder.toString();
    }

    private static String addAtIndex(String inputLine, String location, int index) {
        StringBuilder modified = new StringBuilder(inputLine);
        modified.insert(index, location);
        return modified.toString();
    }

    private static boolean indexIsValid(int index, String inputLine) {
        if (index >= 0 && index <= inputLine.length() - 1) {
            return true;
        }
        return false;
    }
}
