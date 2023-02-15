/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 12.2.2023 г.
 * Time: 10:06
 */
package P23BitwiseOperations;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class P3PthBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());
        List<Integer> integerList = new ArrayList<>();
        String binary = Integer.toBinaryString(number);

        int bit = Integer.parseInt(binary) << 8;


        System.out.println(number);
    }
}
