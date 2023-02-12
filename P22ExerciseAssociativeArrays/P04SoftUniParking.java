/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 17:41
 */
package P22ExerciseAssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> parkingLot = new LinkedHashMap<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] inputArr = scanner.nextLine().split(" ");
            String command = inputArr[0];
            switch (command) {
                case "register":
                    String user = inputArr[1];
                    String number = inputArr[2];
                    if (parkingLot.containsKey(user)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingLot.get(user));
                    } else {
                        parkingLot.put(user, number);
                        System.out.printf("%s registered %s successfully%n", user, number);
                    }
                    break;
                case "unregister":
                    user = inputArr[1];
                    if (!parkingLot.containsKey(user)) {
                        System.out.printf("ERROR: user %s not found%n", user);
                    } else {
                        parkingLot.remove(user);
                        System.out.printf("%s unregistered successfully%n", user);
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> stringStringEntry : parkingLot.entrySet()) {
            System.out.printf("%s => %s%n",stringStringEntry.getKey(),stringStringEntry.getValue());
        }
    }
}
