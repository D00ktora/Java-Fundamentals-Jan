/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 16:28
 */
package P16ExamPreparation2;

import java.beans.PropertyEditorManager;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shopingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            if (command.contains("Urgent")) {
                if (!isInList(shopingList,command)) {
                    urgent(shopingList,command);
                }
            } else if (command.contains("Unnecessary")) {
                if (isInList(shopingList,command)){
                    unnecessary(shopingList,command);
                }
            } else if (command.contains("Correct")) {
                if (isInList(shopingList,command)) {
                    correct(shopingList, command);
                }
            } else if (command.contains("Rearrange")) {
                if (isInList(shopingList,command)) {
                    rearrange(shopingList,command);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", shopingList));
    }
    public static boolean isInList (List<String> shopingList, String command) {
        String grocery = command.split(" ")[1];
        if (shopingList.contains(grocery)) {
            return true;
        } else {
            return false;
        }
    }
    public static void urgent (List<String> shopingList, String command) {
        String grocery = command.split(" ")[1];
        shopingList.add(0, grocery);
    }
    public static void unnecessary (List<String> shopingList, String command) {
        String grocery = command.split(" ")[1];
        shopingList.remove(grocery);
    }
    public static void correct (List<String> shopingList, String command) {
        String oldItem = command.split(" ")[1];
        String newItem = command.split(" ")[2];
        int index = -9999;
        for (int i = 0; i < shopingList.size(); i++) {
            if (shopingList.get(i).equals(oldItem)){
                shopingList.set(i, newItem);
                break;
            }
        }
    }
    public static void rearrange (List<String> shopingList, String command) {
        String grocery = command.split(" ")[1];
        int index = -9999;
        for (int i = 0; i < shopingList.size(); i++) {
            if (shopingList.get(i).equals(grocery)) {
                index = i;
                break;
            }
        }
        shopingList.add(shopingList.get(index));
        shopingList.remove(index);
    }
}
