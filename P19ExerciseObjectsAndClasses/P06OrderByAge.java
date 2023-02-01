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

public class P06OrderByAge {


    public static class People {
        String name;
        String ID;
        int age;

        void printPeople() {
            System.out.printf("%s with ID: %s is %d years old.%n", this.name, this.ID, this.age);
        }

        public People(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<People> peopleList = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.contains("End")) {
            String name = command.split(" ")[0];
            String ID = command.split(" ")[1];
            int age = Integer.parseInt(command.split(" ")[2]);
            People person = new People(name, ID, age);
            peopleList.add(person);
            command = scanner.nextLine();
        }

        for (int i = 0; i < peopleList.size() - 1; i++) {
            People a = peopleList.get(i);
            People b = peopleList.get(i+1);
            if (a.age > b.age) {
                People temp = a;
                peopleList.set(i, b);
                peopleList.set(i + 1, temp);
                i = -1;
            }
        }

        for (People people : peopleList) {
            people.printPeople();
        }
    }
}
