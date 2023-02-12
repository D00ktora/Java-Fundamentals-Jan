/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 16:16
 */
package P22ExerciseAssociativeArrays;

import java.util.*;

public class P03Orders {

    public static class MyClass {
        String name;
        double price;

        public MyClass(String name, double price, int number) {
            this.name = name;
            this.price = price;
            this.number = number;
        }

        int number;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MyClass> myClassList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.contains("buy")) {
            String[] inputArr = input.split(" ");
            String name = inputArr[0];
            Double price = Double.parseDouble(inputArr[1]);
            int number = Integer.parseInt(inputArr[2]);
            boolean isExist = false;
            for (MyClass myClass : myClassList) {
                if (myClass.name.equals(name)) {
                    myClass.price = price;
                    myClass.number += number;
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                MyClass temp = new MyClass(name, price,number);
                myClassList.add(temp);
            }

            input = scanner.nextLine();
        }

        for (MyClass myClass : myClassList) {
            System.out.printf("%s -> %.2f%n", myClass.name, myClass.number * myClass.price);
        }
    }
}
