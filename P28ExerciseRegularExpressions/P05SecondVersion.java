/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 18.2.2023 г.
 * Time: 19:04
 */
package P28ExerciseRegularExpressions;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class P05SecondVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> daemons = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .map(String::trim)
                .collect(Collectors.toList());

        Pattern healthPattern = Pattern.compile("[^-+*/.\\d]");
        Pattern damagePattern = Pattern.compile("[-+]?\\d+(\\.\\d+)?");
        Pattern damageModifiersPattern = Pattern.compile("[*/]");

        for (String daemonName : daemons) {
            int daemonHealth = healthPattern.matcher(daemonName)
                    .results()
                    .mapToInt(m -> m.group().charAt(0))
                    .sum();

            double daemonDamage = damagePattern.matcher(daemonName)
                    .results()
                    .map(MatchResult::group)
                    .mapToDouble(Double::parseDouble)
                    .sum();

            Matcher matcher = damageModifiersPattern.matcher(daemonName);
            while (matcher.find()) {
                if (matcher.group().equals("*")) {
                    daemonDamage *= 2.0;
                } else {
                    daemonDamage /= 2.0;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", daemonName, daemonHealth, daemonDamage);
        }
    }
}
