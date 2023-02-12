/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 18:21
 */
package P22ExerciseAssociativeArrays;

import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Double>> students = new LinkedHashMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());
            if (students.containsKey(name)) {
                List<Double> temp = students.get(name);
                temp.add(grade);
                students.put(name,temp);
            } else {
                List<Double> temp = new ArrayList<>();
                temp.add(grade);
                students.put(name,temp);
            }
        }

        for (Map.Entry<String,List<Double>> entry : students.entrySet()) {
            List<Double> studentGrade = entry.getValue();
            String name = entry.getKey();
            double sum = 0;
            for (Double aDouble : studentGrade) {
                sum += aDouble;
            }
            double average = sum*1.0/studentGrade.size()*1.0;
            if (!(average < 4.50)) {
                System.out.printf("%s -> %.2f%n",name, average);
            }
        }
    }
}
