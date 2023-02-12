/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 16:10
 */
package P22ExerciseAssociativeArrays;

import java.io.FilterOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> resourceMap = new LinkedHashMap<>();

        while (!input.contains("stop")) {
            int number = Integer.parseInt(scanner.nextLine());
            if (resourceMap.containsKey(input)) {
                resourceMap.put(input, resourceMap.get(input) + number);
            } else {
                resourceMap.put(input, number);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : resourceMap.entrySet()) {
            System.out.printf("%s -> %d%n",stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }
}
