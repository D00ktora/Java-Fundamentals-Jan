package P08ExerciseArrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class P14LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int arrLength = arr.length;

        constructPrintLIS(arr, arrLength);


    }
    static void printLIS(Vector<Integer> arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
    static void constructPrintLIS(int arr[], int n) {
        Vector<Integer> L[] = new Vector[n];
        for (int i = 0; i < L.length; i++)
            L[i] = new Vector<Integer>();
        L[0].add(arr[0]);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[i] > arr[j]) &&
                        (L[i].size() < L[j].size() + 1))
                    L[i] = (Vector<Integer>) L[j].clone();
            }
            if (arr[i] >= 0) {
                L[i].add(arr[i]);
            }
        }
        Vector<Integer> max = L[0];
        for (Vector<Integer> x : L)
            if (x.size() > max.size())
                max = x;
        printLIS(max);
    }
}
