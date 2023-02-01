/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 31.1.2023 г.
 * Time: 18:13
 */
package P18ObjectsAndClasses;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01RandomizeWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Random random = new Random();
        for (int i = 0; i < words.size(); i++) {
            int newIndex = random.nextInt(words.size());
            System.out.println(words.get(newIndex));
            words.remove(newIndex);
            i--;
        }
    }
}
