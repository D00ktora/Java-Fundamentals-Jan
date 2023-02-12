/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 11.2.2023 г.
 * Time: 17:12
 */
package P22ExerciseAssociativeArrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P13MOBAChallenger {

    public static class Person {
        String name;
        String role;
        int points;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public Person(String name, String role, int points) {
            this.name = name;
            this.role = role;
            this.points = points;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Person>> personMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.contains("Season end")) {
            if (input.contains("->")) {
                String[] inputArr = input.split("\\s+->\\s+");
                String name = inputArr[0];
                String role = inputArr[1];
                int points = Integer.parseInt(inputArr[2]);
                Person person = new Person(name, role, points);

                if (!personMap.containsKey(name)) {
                    List<Person> tempList = new ArrayList<>();
                    tempList.add(person);
                    personMap.put(name, tempList);
                } else {
                    List<Person> tempList = personMap.get(name);
                    for (Person person1 : tempList) {
                        if (person1.getRole().equals(role)) {
                            if (person1.getPoints() < points) {
                                person1.setPoints(points);
                                personMap.put(name, tempList);
                                break;
                            }
                        } else {
                            Person person2 = new Person(name, role, points);
                            tempList.add(person2);
                            personMap.put(name, tempList);
                            break;
                        }
                    }
                }
            } else if (input.contains("vs")) {
                String player1Name = input.split("\\s+vs\\s+")[0];
                String player2Name = input.split("\\s+vs\\s+")[1];

                if (personMap.containsKey(player1Name) && personMap.containsKey(player2Name)) {
                    List<Person> player1 = personMap.get(player1Name);
                    List<Person> player2 = personMap.get(player2Name);
                    boolean tie = false;
                    for (Person person1 : player1) {
                        for (Person person2 : player2) {
                            int person1TotalPoints = 0;
                            int person2TotalPoints = 0;
                            if (person1.getRole().equals(person2.getRole())){
                                for (Person personOne : player1) {
                                    person1TotalPoints += personOne.getPoints();
                                }
                                for (Person personTwo : player2) {
                                    person2TotalPoints += personTwo.getPoints();
                                }

                                if (person1TotalPoints > person2TotalPoints) {
                                    //player2.remove(person2);
                                    personMap.remove(player2Name);
                                    tie = true;
                                } else if (person2TotalPoints > person1TotalPoints) {
                                    //player1.remove(person1);
                                    personMap.remove(player1Name);
                                    tie = true;
                                } else {
                                    tie = true;
                                }
                                if (tie) {
                                    break;
                                }
                            }
                        }
                        if (tie) {
                            break;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }

        Map<String, Integer> personsSum = new TreeMap<>();
        for (Map.Entry<String, List<Person>> stringListEntry : personMap.entrySet()) {
            List<Person> tempPersonsList = stringListEntry.getValue();
            int sum = 0;
            for (Person person : tempPersonsList) {
                sum += person.getPoints();
            }
            personsSum.put(stringListEntry.getKey(), sum);
        }


        LinkedHashMap<String, Integer> sortedMapTotal = new LinkedHashMap<>();
        List<Integer> integerList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : personsSum.entrySet()) {
            integerList.add(entry.getValue());
        }
        Collections.sort(integerList);
        Collections.reverse(integerList);
        for (int num : integerList) {
            for (Map.Entry<String, Integer> entry : personsSum.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMapTotal.put(entry.getKey(), num);
                }
            }
        }




        for (Map.Entry<String, List<Person>> stringListEntry : personMap.entrySet()) {
            List<Person> tempList = stringListEntry.getValue();
            tempList = tempList.stream().sorted(Comparator.comparing(Person::getPoints).reversed().thenComparing(Person::getPoints)).collect(Collectors.toList());
            personMap.put(stringListEntry.getKey(), tempList);
        }

        for (Map.Entry<String, Integer> stringListEntry : sortedMapTotal.entrySet()) {
            System.out.printf("%s: %d skill%n",stringListEntry.getKey(),stringListEntry.getValue());
            for (Map.Entry<String, List<Person>> listEntry : personMap.entrySet()) {
                if (listEntry.getKey().equals(stringListEntry.getKey())) {
                    List<Person> tempPerson = listEntry.getValue();
                    for (Person person : tempPerson) {
                        System.out.printf("- %s <::> %d%n",person.getRole(), person.getPoints());
                    }
                }
            }
        }

        System.out.println();
    }
}
