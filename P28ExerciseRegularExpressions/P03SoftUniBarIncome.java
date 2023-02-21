/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 17.2.2023 г.
 * Time: 5:19
 */
package P28ExerciseRegularExpressions;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<quantity>\\d+)\\|[^|$%.]*?(?<price>\\d+(?:\\.\\d+)?)\\$";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        double totalIncome = 0;
        while (!input.contains("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            String customer = "123456789";
            String product = "123456789";
            String quantity = "-9999";
            String price = "-9999";
            if (matcher.find()) {
                customer = matcher.group("name");
                customer = customer.replace('%',' ');
                customer = customer.trim();
                product = matcher.group("product");
                product = product.replace('<', ' ');
                product = product.replace('>', ' ');
                product = product.trim();
                quantity = matcher.group("quantity");
                quantity = quantity.replace('|', ' ');
                quantity = quantity.trim();
                price = matcher.group("price");
                price = price.replace('$', ' ');
                price = price.trim();

            }
            if (!customer.equals("123456789") && !product.equals("123456789") && !quantity.equals("-9999") && !price.equals("-9999")) {
                double clearPrice = Double.parseDouble(price);
                int clearQuantity = Integer.parseInt(quantity);
                System.out.printf("%s: %s - %.2f%n", customer, product, (clearQuantity * clearPrice * 1.0));
                totalIncome += (clearQuantity * clearPrice * 1.0);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f",totalIncome);
    }
}
