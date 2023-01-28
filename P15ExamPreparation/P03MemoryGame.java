/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 7:37
 */
package P15ExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        int moveCount = 0;
        while (!command.contains("end")) {
            moveCount++;
            List<String> commans = Arrays.stream(command.split(" ")).collect(Collectors.toList());
//            commans.remove(0);
            if (isCheatingIndex(commans, stringList)) {
                addElementToMiddle(stringList, moveCount);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (areTheElementsMaching(commans, stringList)) {
                    command = scanner.nextLine();
                    if (stringList.size() == 0) {
                        System.out.printf("You have won in %d turns!%n",moveCount);
                        return;
                    }
                    continue;
                }else {
                    System.out.println("Try again!");
                }
            }
        command = scanner.nextLine();
        }
        if (stringList.size() == 0) {
            System.out.printf("You have won in %d turns!%n",moveCount);
        } else {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ",stringList));
        }
    }

    private static boolean areTheElementsMaching(List<String> commans, List<String> stringList) {
        int index1 = Integer.parseInt(commans.get(0));
        int index2 = Integer.parseInt(commans.get(1));
        if (stringList.get(index1).equals(stringList.get(index2))) {
            System.out.printf("Congrats! You have found matching elements - %s!%n", stringList.get(index1));
            stringList.set(index1, "-9999999");
            stringList.set(index2, "-9999999");
            for (int i = 0; i < stringList.size(); i++) {
                if (stringList.get(i).equals("-9999999")) {
                    stringList.remove(i);
                    i--;
                }
            }
            return true;
        }else return false;
    }

    public static boolean isCheatingIndex(List<String> commands, List<String> stringList) {
        int firstIndex = Integer.parseInt(commands.get(0));
        int secondIndex = Integer.parseInt(commands.get(1));
        if (commands.get(0).equals(commands.get(1))) {
            return true;
        } else if (firstIndex < 0 || firstIndex > stringList.size() - 1) {
            return true;
        } else if (secondIndex < 0 || secondIndex > stringList.size() - 1) {
            return true;
        }else return false;
    }

    public static void addElementToMiddle(List<String> stringList, int moveCount) {
        String temp = "-";
        temp += moveCount;
        temp += "a";
        stringList.add(stringList.size()/2, temp);
        stringList.add(stringList.size()/2, temp);
    }


}
