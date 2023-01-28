package P08ExerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] input = scanner.nextLine().split(" ");
        String command = input[0];
        int firstIndex = 0;
        int secondIndex = 0;
        while (!command.equals("end")) {

            if (input.length > 1) {
                firstIndex = Integer.parseInt(String.valueOf(input[1]));
                secondIndex = Integer.parseInt(String.valueOf(input[2]));
            }

            switch (command) {
                case "swap":
                    int temp = arrInt[firstIndex];
                    arrInt[firstIndex] = arrInt[secondIndex];
                    arrInt[secondIndex] = temp;
                    break;
                case "multiply":
                    int result = arrInt[firstIndex] * arrInt[secondIndex];
                    arrInt[firstIndex] = result;
                    break;
                case "decrease":
                    for (int i = 0; i < arrInt.length; i++) {
                        arrInt[i] -= 1;
                    }
                    break;
            }

            input = scanner.nextLine().split(" ");
            command = input[0];
        }

        for (int i = 0; i < arrInt.length - 1; i++) {
            System.out.printf("%d, ",arrInt[i]);
        }
        System.out.println(arrInt[arrInt.length - 1]);
    }
}
