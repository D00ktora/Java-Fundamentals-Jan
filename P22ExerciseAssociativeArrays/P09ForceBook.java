/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 7.2.2023 г.
 * Time: 6:10
 */
package P22ExerciseAssociativeArrays;

import java.util.*;
import java.util.function.DoubleFunction;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> sidesMap = new LinkedHashMap<>();

        String command = scanner.nextLine();
        Map<String, List<String>> map = new LinkedHashMap<>();

        while (!command.contains("Lumpawaroo")) {

            if (command.contains(" | ")) {
                String group = command.split("\\s+\\|\\s+")[0];
                String user = command.split("\\s+\\|\\s+")[1];

                if (!map.containsKey(group)) {
                    map.put(group, new ArrayList<>());
                }

                boolean isUserExist = false;

                for (List<String> listUsers : map.values()) {
                    if (listUsers.contains(user)) {
                        isUserExist = true;
                        break;
                    }
                }

                if (!isUserExist) {
                    map.get(group).add(user);
                }

            } else if (command.contains(" -> ")){
                String user = command.split("\\s+->\\s+")[0];
                String group = command.split("\\s+->\\s+")[1];

                map.entrySet().forEach(entry -> entry.getValue().remove(user));

                if (map.containsKey(group)) {
                    map.get(group).add(user);
                } else {
                    map.put(group, new ArrayList<>());
                    map.get(group).add(user);
                }

                System.out.printf("%s joins the %s side!%n", user, group);
            }

            command = scanner.nextLine();
        }

        map.entrySet().stream().filter(entry -> entry.getValue().size() > 0).forEach(entry -> {
            System.out.printf("Side: %s, Members: %d%n",entry.getKey(), entry.getValue().size());
            entry.getValue().forEach(user -> System.out.println("! " + user));
        });
    }
}
