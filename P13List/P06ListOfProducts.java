package P13List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLists = Integer.parseInt(scanner.nextLine());
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < numberOfLists; i++) {
            String temp = scanner.nextLine();
            stringList.add(temp);
        }
        Collections.sort(stringList);
        int num = 1;
        for (String s : stringList) {
            System.out.printf("%d.%s%n",num, s);
            num++;
        }
    }
}

//4
//Potatoes
//Tomatoes
//Onions
//Apples
//
//
//3
//Orange
//Grape
//Strawberry