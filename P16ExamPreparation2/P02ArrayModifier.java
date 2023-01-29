/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 15:23
 */
package P16ExamPreparation2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.contains("end")) {
            if (command.contains("swap")){
                swap(integerList,command);
            } else if (command.contains("multiply")) {
                multiply(command, integerList);
            } else if (command.contains("decrease")) {
                decrease(integerList);
            }
            command = scanner.nextLine();
        }
        printList(integerList);
    }

    private static void printList(List<Integer> integerList) {
        List<String> stringList = new ArrayList<>();
        for (Integer integer : integerList) {
            stringList.add("" + integer);
        }

        System.out.println(String.join(", ",stringList));
    }

    public static void swap(List<Integer> integerList, String command) {
        if (checkTheIndexes(integerList, command)){
            int index1 = Integer.parseInt(command.split(" ")[1]);
            int index2 = Integer.parseInt(command.split(" ")[2]);
            int temp = integerList.get(index1);
            integerList.set(index1, integerList.get(index2));
            integerList.set(index2, temp);
        }
    }

    private static boolean checkTheIndexes(List<Integer> integerList, String command) {
        int index1 = Integer.parseInt(command.split(" ")[1]);
        int index2 = Integer.parseInt(command.split(" ")[2]);
        if (index1 < 0)
            return false;
        if (index2 > integerList.size() - 1)
            return false;
        return true;
    }

    public static void multiply(String command, List<Integer> integerList) {
        if (checkTheIndexes(integerList, command)) {
            int index1 = Integer.parseInt(command.split(" ")[1]);
            int index2 = Integer.parseInt(command.split(" ")[2]);
            int val1 = integerList.get(index1);
            int val2 = integerList.get(index2);
            int result = val1 * val2;
            integerList.set(index1, result);
        }
    }

    public static void decrease(List<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            integerList.set(i, integerList.get(i) - 1);
        }
    }
}
