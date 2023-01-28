package P14ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String operations = scanner.nextLine();

        while (!operations.contains("End")) {
            if (operations.contains("Add")){
                int number = Integer.parseInt(operations.split(" ")[1]);
                numbers.add(number);
            } else if (operations.contains("Insert")) {
                int number = Integer.parseInt(operations.split(" ")[1]);
                int index = Integer.parseInt(operations.split(" ")[2]);
                if (index < 0 || index > numbers.size() - 1){
                    System.out.println("Invalid index");
                    operations = scanner.nextLine();
                    continue;
                }
                numbers.add(index,number);
            } else if (operations.contains("Remove")) {
                int number = Integer.parseInt(operations.split(" ")[1]);
                if (number < 0 || number > numbers.size() - 1){
                    System.out.println("Invalid index");
                    operations = scanner.nextLine();
                    continue;
                }
                numbers.remove(number);
            } else if (operations.contains("Shift left")) {
                int times = Integer.parseInt(operations.split(" ")[2]);
                for (int i = 0; i < times; i++) {
                    numbers.add(numbers.get(0));
                    numbers.remove(0);
                }
            } else if (operations.contains("Shift right")) {
                int times = Integer.parseInt(operations.split(" ")[2]);
                for (int i = 0; i < times; i++) {
                    numbers.add(0, numbers.get(numbers.size() - 1));
                    numbers.remove(numbers.size()-1);
                }
            }

            operations = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }
    }
}