/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 8:02
 */
package P16ExamPreparation2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.contains("End")) {
            if (command.contains("Shoot")) {
                shoot(command,targets);
            } else if (command.contains("Add")) {
                add(command,targets);
            }else if (command.contains("Strike")) {
                strike(command,targets);
            }
            command = scanner.nextLine();
        }
        printTargets(targets);
    }

    private static boolean indexExist(String command, List<Integer> targets) {
        int index = Integer.parseInt(command.split(" ")[1]);
        if (index < 0) {
            return false;
        } else if (index > targets.size() -1) {
            return false;
        } else return true;
    }

    private static boolean indexExist(int index, List<Integer> targets) {
        if (index < 0) {
            return false;
        } else if (index > targets.size() -1) {
            return false;
        } else return true;
    }

    private static void shoot(String command, List<Integer> targets) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int power = Integer.parseInt(command.split(" ")[2]);
        if (indexExist(command,targets)) {
            if (targets.get(index) - power <= 0) {
                targets.remove(index);
            }else {
                targets.set(index, targets.get(index) - power);
            }
        }
    }

    public static void add(String command, List<Integer> targets) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int value = Integer.parseInt(command.split(" ")[2]);
        if (indexExist(command,targets)) {
            targets.add(index, value);
        }else {
            System.out.println("Invalid placement!");
        }
    }

    public static void strike(String command, List<Integer> targets) {
        int index = Integer.parseInt(command.split(" ")[1]);
        int radius = Integer.parseInt(command.split(" ")[2]);
        int lowerRange = index - radius;
        int upperRange = index + radius;
        if (indexExist(command, targets) && indexExist(lowerRange, targets) && indexExist(upperRange, targets)) {
            for (int i = lowerRange; i <= upperRange; i++) {
                targets.set(i, -999999);
            }
            for (int i = 0; i < targets.size(); i++) {
                if (targets.get(i) == -999999) {
                    targets.remove(i);
                    i--;
                }
            }
        } else {
            System.out.println("Strike missed!");
        }
    }

    public static void printTargets(List<Integer> targets) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < targets.size(); i++) {
            stringList.add(String.valueOf(targets.get(i)));
        }
        System.out.println(String.join("|", stringList));
    }
}
