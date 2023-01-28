package P14ExerciseList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < numberOfLines; i++) {
            String command = scanner.nextLine();
            if (command.contains("is going")){
                String name = command.split(" ")[0];
                if (names.contains(name)){
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    names.add(name);
                }
            } else if (command.contains("is not going")) {
                String name = command.split(" ")[0];
                if (names.contains(name)) {
                    names.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
