/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 15.2.2023 г.
 * Time: 5:13
 */
package P25ExerciseTextProcessing;

import java.util.Scanner;

public class P10AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextLine().charAt(0);
        int end = scanner.nextLine().charAt(0);
        String input = scanner.nextLine();
        //String subString = input.substring(start + 1, end);
        char[] stringArr = input.toCharArray();
        int sum = 0;
        for (char charr : stringArr) {
            if (charr > start && charr < end) {
                sum += charr;
            }
        }
        System.out.println(sum);
    }
}
