package P10Methods;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        printTriangle(size);
    }

    private static void printTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ",j);
            }
            System.out.println();
        }
        for (int i = size; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                System.out.printf("%d ",j);
            }
            System.out.println();
        }
    }
}
