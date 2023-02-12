/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 9.2.2023 г.
 * Time: 5:31
 */
package P22ExerciseAssociativeArrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> judge = new LinkedHashMap<>();
        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> submitions = new LinkedHashMap<>();
        while (!input.contains("exam finished")) {
            String[] splitInput = input.split("-");
            boolean isInputForRemove = splitInput.length > 2;
            if (isInputForRemove) {
                String userName = splitInput[0];
                String language = splitInput[1];
                String points = splitInput[2];
                boolean isLanguageAveilible = judge.containsKey(language);
                if (!isLanguageAveilible) {
                    LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
                    temp.put(userName,Integer.parseInt(points));
                    judge.put(language,temp);
                    submitions.put(language, 1);
                } else {
                    LinkedHashMap<String, Integer> temp = judge.get(language);
                    int increasSubmitions = submitions.get(language);
                    increasSubmitions++;
                    submitions.put(language,increasSubmitions);
                    if (temp.containsKey(userName)) {
                        int number = temp.get(userName);
                        if (number < Integer.parseInt(points)) {
                            temp.put(userName, Integer.parseInt(points));
                            judge.put(language, temp);
                        }
                    } else {
                        temp.put(userName, Integer.parseInt(points));
                        judge.put(language, temp);
                    }
                }
            } else if (splitInput.length == 2) {
                String userName = splitInput[0];
                for (LinkedHashMap<String, Integer> value : judge.values()) {
                    if (value.containsKey(userName)) {
                        value.put(userName, -999);
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");
        for (Map.Entry<String, LinkedHashMap<String, Integer>> value : judge.entrySet()) {
            for (Map.Entry<String, Integer> integer : value.getValue().entrySet()) {
                if (integer.getValue() != -999) {
                    System.out.printf("%s | %d%n",integer.getKey(), integer.getValue());
                }
            }
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> stringLinkedHashMapEntry : submitions.entrySet()) {
            System.out.printf("%s - %d%n", stringLinkedHashMapEntry.getKey(), stringLinkedHashMapEntry.getValue());
        }
    }
}
