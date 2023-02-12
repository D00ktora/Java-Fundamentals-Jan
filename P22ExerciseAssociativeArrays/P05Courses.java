/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 17:52
 */
package P22ExerciseAssociativeArrays;

import java.util.*;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashSet<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.contains("end")) {
            String[] course = input.split(" : ");
            String courseName = course[0];
            String studentName = course[1];
            if (courses.containsKey(courseName)) {
                LinkedHashSet<String> temp = courses.get(courseName);
                temp.add(studentName);
                courses.put(courseName, temp);
            } else {
                LinkedHashSet<String> temp = new LinkedHashSet<>();
                temp.add(studentName);
                courses.put(courseName, temp);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashSet<String>> stringLinkedHashSetEntry : courses.entrySet()) {
            System.out.printf("%s: %d%n",stringLinkedHashSetEntry.getKey(), stringLinkedHashSetEntry.getValue().size());
            LinkedHashSet<String> temp = stringLinkedHashSetEntry.getValue();
            for (String s : temp) {
                System.out.printf("-- %s%n",s);
            }
        }
    }
}
