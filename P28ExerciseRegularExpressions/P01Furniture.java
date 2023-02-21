/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 16.2.2023 г.
 * Time: 6:31
 */
package P28ExerciseRegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";
        while (!input.contains("Purchase")) {
            result += input;
            result += " ";
            input = scanner.nextLine();
        }

        String regex = ">>(?<city>[A-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(result);

        List<String> furniture = new ArrayList<>();
        double sum = 0;
        while (matcher.find()) {
            String city = matcher.group("city");
            double price = Double.parseDouble(matcher.group("price"));
            int quantity = Integer.parseInt(matcher.group("quantity"));
            furniture.add(city);
            sum += (quantity * price);
        }
        System.out.println("Bought furniture:");
        System.out.println(String.join(System.lineSeparator(), furniture));
        System.out.printf("Total money spend: %.2f",sum);

    }
}
