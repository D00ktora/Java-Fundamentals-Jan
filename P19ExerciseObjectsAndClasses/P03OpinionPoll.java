/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.2.2023 г.
 * Time: 5:43
 */
package P19ExerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03OpinionPoll {

    public static class Person {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void printPerson() {
            System.out.printf("%s - %d%n", this.name, this.age);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int numberOfPersons = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfPersons; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            Person newPerson = new Person(name,age);
            personList.add(newPerson);
        }
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getAge() > 30) {
                personList.get(i).printPerson();
            }
        }
    }
}
