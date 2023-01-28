package P08ExerciseArrays;

import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr1 = scanner.nextLine().split(" ");
        String[] arr2 = scanner.nextLine().split(" ");

        for (int i = 0; i < arr2.length; i++) {
            String temp = arr2[i];
            for (int j = 0; j < arr1.length; j++) {
                if (temp.equals(arr1[j])) {
                    System.out.printf("%s ", arr1[j]);
                }
            }
        }
    }
}
