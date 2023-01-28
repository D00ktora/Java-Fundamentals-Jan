package P08ExerciseArrays;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWagons = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[numberOfWagons];
        int sum = 0;

        for (int i = 0; i < numberOfWagons; i++) {
            int ppl = Integer.parseInt(scanner.nextLine());
            arr[i] = String.valueOf(ppl);
            sum += ppl;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s ",arr[i]);
        }
        System.out.println();
        System.out.println(sum);
    }
}
