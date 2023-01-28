/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 6:16
 */
package P15ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("[|]")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.contains("Yohoho!")) {
            List<String> command = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            if (command.contains("Loot")) {
                sortLoot(treasureChest, command);
                addToBeginningOfTheChest(treasureChest,command);
            } else if (command.contains("Drop")) {
                if (isValidIndex(command, treasureChest)) {
                    removeLoot(treasureChest, command);
                }
            } else if (command.contains("Steal")) {
                if (doWeHaveEnoughItems(treasureChest,command)) {
                    removeAndPrintItems(treasureChest,command);
                }else {
                    removeAllItems(treasureChest);
                }
            }
            input = scanner.nextLine();
        }

        double price = calculatePrice(treasureChest);
        if (treasureChest.size() == 0) {
            System.out.println("Failed treasure hunt.");
        }else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", price);
        }
    }

    public static void sortLoot(List<String> treasureChest, List<String> command) {
        command.remove(0);
        for (int i = 0; i < command.size(); i++) {
            if (treasureChest.contains(command.get(i))) {
                command.remove(i);
                i--;
            }
        }
        Collections.reverse(command);
    }

    public static void addToBeginningOfTheChest(List<String> treasureChest, List<String> command) {
        treasureChest.addAll(0, command);
    }

    public static boolean isValidIndex(List<String> command, List<String> treasureChest) {
        if (Integer.parseInt(command.get(1)) < 0 || Integer.parseInt(command.get(1)) > treasureChest.size() - 1) {
            return false;
        }else {
            return true;
        }
    }
    
    public static void removeLoot(List<String> treasureChest, List<String> command) {
        int index = Integer.parseInt(command.get(1));
        String item = treasureChest.get(index);
        treasureChest.remove(index);
        treasureChest.add(item);
    }

    public static boolean doWeHaveEnoughItems(List<String> treasureChes, List<String> command) {
        int items = Integer.parseInt(command.get(1));
        if (items < treasureChes.size()) {
            return true;
        }else return false;
    }

    public static void removeAndPrintItems(List<String> treasureChes, List<String> command) {
        int items = Integer.parseInt(command.get(1));
        int removingIntex = treasureChes.size()-items;
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < items; i++) {
            temp.add(treasureChes.get(removingIntex));
            treasureChes.remove(removingIntex);
        }
        System.out.println(String.join(", ", temp));
    }

    public static void removeAllItems(List<String> treasureChest) {
        System.out.println(String.join(", ", treasureChest));
        int size = treasureChest.size();
        for (int i = 0; i < treasureChest.size(); i++) {
            treasureChest.remove(i);
            i = -1;
        }
    }

    public static double calculatePrice(List<String> treasureChest) {
        int sumOfLength = 0;
        for (int i = 0; i < treasureChest.size(); i++) {
            sumOfLength += treasureChest.get(i).length();
        }
        double result = sumOfLength * 1.0 / treasureChest.size();
        return result;
    }
}
