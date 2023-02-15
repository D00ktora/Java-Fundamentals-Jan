/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 12.2.2023 г.
 * Time: 10:47
 */
package P24TextProcessing;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(key)) {
            text = text.replace(key, "");
        }
        System.out.println(text);
    }
}
