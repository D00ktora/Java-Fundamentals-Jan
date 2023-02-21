/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.2.2023 г.
 * Time: 14:23
 */
package P30ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<place>([=\\/])(?<name>[A-Z]{1,}[A-z]{2,})\\2)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int distance = 0;
        List<String> locations = new ArrayList<>();
        while (matcher.find()) {
            locations.add(matcher.group("name"));
        }
        for (String location : locations) {
            distance += location.length();
        }
        System.out.printf("Destinations: ");
        System.out.println(String.join(", ",locations));
        System.out.printf("Travel Points: %d",distance);
    }
}
