/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 18:37
 */
package P16ExamPreparation2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while (!commands.contains("Craft!")) {
        String command = commands.split(" - ")[0];
        if (command.contains("Collect")){
            String item = commands.split(" - ")[1];
            if (!isItemExist(items, item)) {
                items.add(item);
            }
        } else if (commands.contains("Drop")) {
            String item = commands.split(" - ")[1];
            if (isItemExist(items, item)){
                items.remove(item);
            }
        } else if (commands.contains("Combine Items")) {
            String item = commands.split(" - ")[1].split(":")[0];
            if (isItemExist(items, item)) {
                int index = findIndex(items,item) + 1;
                String newItem = commands.split(" - ")[1].split(":")[1];
                items.add(index, newItem);
            }
        } else if (commands.contains("Renew")) {
            String item = commands.split(" - ")[1];
            if (isItemExist(items, item)){
                int index = findIndex(items,item);
                String temp = items.get(index);
                items.remove(index);
                items.add(temp);
            }
        }
            commands = scanner.nextLine();
        }
        System.out.println(String.join(", ", items));
    }
    public static boolean isItemExist(List<String> items, String command) {
        if (items.contains(command)) {
            return true;
        }else return false;
    }
    public static int findIndex(List<String> items, String item) {
        int index = -9999;
        //String item = command.split(" - ")[1];
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                return i;
            }
        }
        return index;
    }
}
