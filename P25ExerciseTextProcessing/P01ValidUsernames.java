/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 13.2.2023 г.
 * Time: 4:58
 */
package P25ExerciseTextProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> users = Arrays.stream(scanner.nextLine().split(", ")).map(String::toString).collect(Collectors.toList());
        List<String> firstSort = new ArrayList<>();
        for (String user : users) {
            if (!(user.length() < 3) && !(user.length() > 16)) {
                firstSort.add(user);
            }
        }
        List<String> secondSort = new ArrayList<>();
        for (String sorted : firstSort) {
            if (sorted.matches("[a-zA-Z0-9-_]+")) {
                secondSort.add(sorted);
            }
        }
        for (String thirdSort : secondSort) {
            System.out.println(thirdSort);
        }
    }
}
