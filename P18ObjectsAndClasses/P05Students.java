/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 31.1.2023 г.
 * Time: 18:54
 */
package P18ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {

    public static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        String printStudent() {
            return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.contains("end")) {
            String fitstName = input.split(" ")[0];
            String lastName = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);
            String homeTown = input.split(" ")[3];
            Student newStudent = new Student(fitstName,lastName,age,homeTown);
            students.add(newStudent);
            input = scanner.nextLine();
        }

        String cityName = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getHomeTown().equals(cityName)) {
                System.out.println(students.get(i).printStudent());
            }
        }

    }
}
