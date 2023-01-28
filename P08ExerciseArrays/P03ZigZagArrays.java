package P08ExerciseArrays;

import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = Integer.parseInt(scanner.nextLine());
        String[] firstArrStr = new String[iterations];
        String[] secondArrStr = new String[iterations];

        for (int i = 0; i < iterations; i++) {
            String[] temp = scanner.nextLine().split(" ");

            if (i % 2 == 0) {
                firstArrStr[i] = temp[0];
                secondArrStr[i] = temp[1];
            } else {
                firstArrStr[i] = temp[1];
                secondArrStr[i] = temp[0];
            }
        }

        for (int i = 0; i < firstArrStr.length; i++) {
            System.out.printf("%s ",firstArrStr[i]);
        }

        System.out.println();

        for (int i = 0; i < secondArrStr.length; i++) {
            System.out.printf("%s ", secondArrStr[i]);
        }
    };
}
