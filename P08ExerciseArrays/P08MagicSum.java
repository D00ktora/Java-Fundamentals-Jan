package P08ExerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arrInt.length; i++) {
            for (int j = i + 1; j <= arrInt.length - 1; j++) {
                int sum = arrInt[i] + arrInt[j];
                if (sum == number) {
                    System.out.printf("%d %d%n", arrInt[i], arrInt[j]);
                }
            }
        }
    }
}
