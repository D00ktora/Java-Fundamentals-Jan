package P04DataTypesAndVariables;

import java.util.Scanner;

public class P11RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        System.out.print("Length: ");
        System.out.print("Width: ");

        double height = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");

        double Volume= Double.parseDouble(scanner.nextLine());

        Volume = (length * height * Volume) / 3;

        System.out.printf("Pyramid Volume: %.2f", Volume);

    }
}
