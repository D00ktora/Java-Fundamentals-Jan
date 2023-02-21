/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 16.2.2023 г.
 * Time: 5:53
 */
package P27RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> machedList = new ArrayList<>();

        while (matcher.find()) {
            machedList.add(matcher.group());
        }
        System.out.println(String.join(", ", machedList));
    }
}
