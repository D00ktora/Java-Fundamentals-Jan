package P13List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("end")) {
            String tempComand = command[0];
            switch (tempComand) {
                case "Add":
                    int numberToAdd = Integer.parseInt(String.valueOf(command[1]));
                    integerList.add(numberToAdd);
                break;
                case "Remove" :
                    Integer numberToRemove = Integer.parseInt(String.valueOf(command[1]));
                    integerList.remove(numberToRemove);
                break;
                case "RemoveAt":
                    int numberToRemoveAt = Integer.parseInt(String.valueOf(command[1]));
                    integerList.remove(numberToRemoveAt);
                break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(String.valueOf(command[1]));
                    int index = Integer.parseInt(String.valueOf(command[2]));
                    integerList.add(index, numberToInsert);
                break;
            }

            command = scanner.nextLine().split(" ");
        }

        for (Integer integer : integerList) {
            System.out.printf("%d ", integer);
        }
    }
}
