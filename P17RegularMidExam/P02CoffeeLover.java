/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.2.2023 г.
 * Time: 7:11
 */
package P17RegularMidExam;

import java.util.*;
import java.util.stream.Collectors;

public class P02CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> coffeList = new ArrayList<>();
        String input = scanner.nextLine();
        coffeList = Arrays.stream(input.split(" ")).map(String::toString).collect(Collectors.toList());
        int commands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commands; i++) {
            String command = scanner.nextLine();
            if (command.contains("Include")) {
                String coffeToAdd = command.split(" ")[1];
                coffeList.add(coffeToAdd);
            } else if (command.contains("Remove")) {
                String frontOrBack = command.split(" ")[1];
                int numberOfCoffesToRemove = Integer.parseInt(command.split(" ")[2]);
                if (frontOrBack.contains("first")) {
                    for (int j = 0; j < numberOfCoffesToRemove; j++) {
                        coffeList.remove(0);
                    }
                } else if (frontOrBack.contains("last")) {
                    for (int j = 0; j < numberOfCoffesToRemove; j++) {
                        coffeList.remove(coffeList.size() - 1);
                    }
                }
            } else if (command.contains("Prefer")) {
                int index1 = Integer.parseInt(command.split(" ")[1]);
                int index2 = Integer.parseInt(command.split(" ")[2]);
                if (index1 >= 0 && index2 >= 0 && index1 < coffeList.size() && index2 < coffeList.size()) {
                    String coffeToGet = coffeList.get(index1);
                    coffeList.set(index1, coffeList.get(index2));
                    coffeList.set(index2, coffeToGet);
                }
            } else if (command.contains("Reverse")) {
                Collections.reverse(coffeList);
            }
        }

        System.out.println("Coffees:");
        System.out.println(String.join(" ",coffeList));
    }
}
