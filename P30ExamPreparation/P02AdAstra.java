/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.2.2023 г.
 * Time: 7:44
 */
package P30ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(?<delimiter>[#\\|])(?<itemName>\\w+\\s*\\w*)\\1(?<expirationDate>[\\d]{2}[/][\\d]{2}[/][\\d]{2})\\1(?<calories>[\\d]+)\\1");
        Matcher matcher = pattern.matcher(input);
        int sumOfCalories = 0;
        List<String> food = new ArrayList<>();

        while (matcher.find()) {
            String foodname = matcher.group("itemName");
            String foodExpriration = matcher.group("expirationDate");
            String foodCalories = matcher.group("calories");
            String result = "Item: " + foodname + ", Best before: " + foodExpriration + ", Nutrition: " + foodCalories;
            food.add(result);
            sumOfCalories += Integer.parseInt(foodCalories);
        }

        int calculatedDays = sumOfCalories / 2000;

        if (food.size() > 0) {
            System.out.printf("You have food to last you for: %d days!%n",calculatedDays);
            for (String fo : food) {
                System.out.println(fo);
            }
        } else {
            System.out.printf("You have food to last you for: 0 days!%n");
        }
    }
}
