/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.2.2023 г.
 * Time: 5:43
 */
package P19ExerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P04Students {
    public static class Student {
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        void printStudent() {
            System.out.printf("%s %s: %.2f%n",this.firstName, this.lastName, this.grade);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String input = scanner.nextLine();
            String fName = input.split(" ")[0];
            String lName = input.split(" ")[1];
            double grade = Double.parseDouble(input.split(" ")[2]);
            Student newStudent = new Student(fName, lName, grade);
            studentList.add(newStudent);
        }
        for (int i = 0; i < studentList.size() - 1; i++) {
            Student a = studentList.get(i);
            Student b = studentList.get(i+1);
            if (a.grade < b.grade) {
                Student temp = a;
                studentList.set(i, b);
                studentList.set(i + 1, temp);
                i = -1;
            }
        }
        for (Student student : studentList) {
            student.printStudent();
        }
    }
}
