package P14ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String commands = scanner.nextLine();

        while (!commands.contains("course start")) {
            if (commands.contains("Add")){
                addCommand(stringList, commands);
            } else if (commands.contains("Insert")) {
                insert(stringList, commands);
            } else if (commands.contains("Remove")) {
                remove(stringList, commands);
            } else if (commands.contains("Swap")) {
                //!!!!!!Има бъг в тази функция, не ги пренарежда правилно!!!!
                swap(stringList, commands);
            } else if (commands.contains("Exercise")) {
                exercise(stringList, commands);
            }
            commands = scanner.nextLine();
        }

        for (int i = 0; i < stringList.size(); i++) {
            System.out.printf("%d.%s%n",i+1,stringList.get(i));
        }
    }

    public static void addCommand (List<String> stringList, String commands) {
        String lesson = commands.split(":")[1];
        if (!stringList.contains(lesson)) {
            stringList.add(lesson);
        }
    }

    public static void insert(List<String> stringList, String commands) {
        String lesson = commands.split(":")[1];
        int index = Integer.parseInt(commands.split(":")[2]);
        if (!stringList.contains(lesson)) {
            stringList.add(index, lesson);
        }
    }

    public static void remove(List<String> stringList, String commands) {
        String lesson = commands.split(":")[1];
        if (stringList.contains(lesson)) {
            if (stringList.contains(lesson+"-Exercise")) {
                stringList.remove(lesson);
                stringList.remove(lesson+"-Exercise");
            }else {
                stringList.remove(lesson);
            }
        }
    }

    public static void swap(List<String> stringList, String commands) {
        String lesson1 = commands.split(":")[1];
        String lesson2 = commands.split(":")[2];
        if (stringList.contains(lesson1) && stringList.contains(lesson2)) {
            int index1 = 0;
            int index2 = 0;
            String temp;
            boolean lesson1Exist = false;
            boolean lesson2Exist = false;
            int indexExercise1 = 0;
            int indexExercise2 = 0;
            String exercise1 = lesson1+"-Exercise";
            String exercise2 = lesson2+"-Exercise";
            for (int i = 0; i < stringList.size(); i++) {
                if (stringList.get(i).equals(lesson1)){
                    index1 = i;
                } else if (stringList.get(i).equals(lesson2)) {
                    index2 = i;
                }
                if (stringList.get(i).equals(exercise1)){
                    lesson1Exist = true;
                    indexExercise1 = i;
                    exercise1 = stringList.get(i);
                } else if (stringList.get(i).equals(exercise2)) {
                    lesson2Exist = true;
                    indexExercise2 = i;
                    exercise2 = stringList.get(i);
                }
            }
            if (lesson1Exist && lesson2Exist) {
                stringList.set(index1, lesson2);
                stringList.set(index2, lesson1);
                stringList.set(indexExercise1, exercise2);
                stringList.set(indexExercise2, exercise1);
            } else if (lesson1Exist) {
                stringList.set(index1, lesson2);
                stringList.set(index2, lesson1);
                if (index2 < stringList.size() - 1) {
                    stringList.add(index2+1, exercise1);
                    stringList.remove(index1+2);
                }else {
                    stringList.add(exercise1);
                    stringList.remove(index1+1);
                }
            } else if (lesson2Exist) {
                stringList.set(index1, lesson2);
                stringList.set(index2, lesson1);
                if (index1 < stringList.size() - 1) {
                    stringList.add(index1+1, exercise2);
                    stringList.remove(index2+2);
                }else {
                    stringList.add(exercise2);
                    stringList.remove(index1+1);
                }
            } else if (!lesson1Exist && !lesson2Exist) {
                stringList.set(index1, lesson2);
                stringList.set(index2, lesson1);
            }
        }
    }

    public static void exercise(List<String> stringList, String commands) {
        String lesson = commands.split(":")[1];
        if (stringList.contains(lesson)) {
            if (!stringList.contains(lesson+"-"+"Exercise")){
                int index = 0;
                for (int i = 0; i < stringList.size(); i++) {
                    if (stringList.get(i).equals(lesson)) {
                        index = i;
                        break;
                    }
                }
                if (index == stringList.size() - 1) {
                    //Ако е последен елемент, само аддваме
                    stringList.add(lesson+"-Exercise");
                } else {
                    stringList.add(index+1,lesson+"-Exercise");
                }
            }
        } else if (!stringList.contains(lesson)) {
            stringList.add(lesson);
            stringList.add(lesson+"-Exercise");
        }
    }
}
