/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 7.2.2023 г.
 * Time: 6:09
 */
package P22ExerciseAssociativeArrays;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashSet<String>> companies = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.contains("End")) {
            String[] inputArr = input.split(" -> ");
            String company = inputArr[0];
            String id = inputArr[1];
            LinkedHashSet<String> temp = new LinkedHashSet<>();
            if (!companies.containsKey(company)) {
                temp.add(id);
                companies.put(company,temp);
            } else {
                temp = companies.get(company);
                temp.add(id);
                companies.put(company,temp);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashSet<String>> stringLinkedHashSetEntry : companies.entrySet()) {
            LinkedHashSet <String> temp = stringLinkedHashSetEntry.getValue();
            System.out.printf("%s%n", stringLinkedHashSetEntry.getKey());
            for (String s : temp) {
                System.out.printf("-- %s%n",s);
            }
        }
    }
}
