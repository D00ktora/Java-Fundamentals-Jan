package P22ExerciseAssociativeArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> forceBook = new TreeMap<>();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains(" -> ")) {
                String[] token = input.split(" -> ");
                String forceSide = token[1];
                String forceUser = token[0];

                if (!contains(forceBook, forceUser)) {
                    for (Map.Entry<String, List<String>> current : forceBook.entrySet()) {
                        if (current.getValue().contains(forceUser)) {
                            forceBook.get(current.getKey()).remove(forceUser);
                            break;
                        }
                    }
                    if (!forceBook.containsKey(forceSide)){
                        forceBook.putIfAbsent(forceSide, new ArrayList<>());
                    }
                    forceBook.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
//                    if (!forceBook.containsKey(forceSide)) {
//                        forceBook.put(forceSide, new ArrayList<>());
//                    }
//                    forceBook.get(forceSide).add(forceUser);
//                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                } else {
                    for (List<String> list : forceBook.values()) {
                        list.remove(forceUser);
                    }

                    forceBook.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                }
            }
            else {
            String[] token = input.split(" \\| ");
            String forceSide = token[0];
            String forceUser = token[1];

            if (!forceBook.containsKey(forceSide)) {
                forceBook.put(forceSide, new ArrayList<>());
            }

            if (!contains(forceBook, forceUser)) {
                forceBook.get(forceSide).add(forceUser);
            }
            input = scanner.nextLine();
        }
}
        for (Map.Entry<String, List<String>> stringListEntry : forceBook.entrySet()) {
            if (stringListEntry.getValue().size() > 0) {
                System.out.printf("Side: %s, Members: %d%n", stringListEntry.getKey(), stringListEntry.getValue().size());
                for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                    System.out.printf("! %s%n", stringListEntry.getValue().get(i));
                }
            }
        }
    }


    static boolean contains(Map<String, List<String>> map, String value) {
        for (List<String> list : map.values()) {
            if (list.contains(value)) return true;
        }
        return false;
    }
}