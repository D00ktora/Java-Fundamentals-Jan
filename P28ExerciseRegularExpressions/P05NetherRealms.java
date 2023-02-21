/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.2.2023 г.
 * Time: 18:05
 */
package P28ExerciseRegularExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P05NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> names = Arrays.stream(input.split(",\\s*")).collect(Collectors.toList());

        for (String name : names) {
            Pattern pattern = Pattern.compile("(?<health>[^-+*/.\\d])");
            Matcher matcher = pattern.matcher(name);
            List<String> letters = new ArrayList<>();
            List<Double> numbers = new ArrayList<>();
            List<String> operations = new ArrayList<>();
            while (matcher.find()) {
                letters.add(matcher.group("health"));
            }
            pattern = Pattern.compile("(?<numbers>[-+]?\\d+(\\.\\d+)?)");
            matcher = pattern.matcher(name);
            while (matcher.find()) {
                String number = matcher.group("numbers");
                if (number.charAt(0) == '-') {
                    String clearNumber = "";
                    for (int i = 1; i < number.length(); i++) {
                        clearNumber += number.charAt(i);
                    }
                    number = clearNumber;
                    double negativNumber = Double.parseDouble(number) * -1.0;
                    numbers.add(negativNumber);
                    continue;
                }
                double clearNumber = Double.parseDouble(number);
                numbers.add(clearNumber);
            }

            pattern = Pattern.compile("(?<operations>[*/])");
            matcher = pattern.matcher(name);
            while (matcher.find()) {
                operations.add(matcher.group("operations"));
            }

            int health = 0;
            double damage = 0;
            String demonName = "";
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ') {
                    demonName += name.charAt(i);
                }
            }
            for (String letter : letters) {
                health += letter.charAt(0);
            }
            for (Double number : numbers) {
                damage += number;
            }
            for (String operation : operations) {
                if (operation.equals("*")) {
                    damage = damage * 2;
                } else if (operation.equals("/")) {
                    damage = damage / 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demonName, health, damage);
        }
    }
}
