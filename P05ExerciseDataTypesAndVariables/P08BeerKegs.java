package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterator = Integer.parseInt(scanner.nextLine());
        String nameOfBiggest = "";
        double biggerKeg = 0.0;
        for (int i = 0; i < iterator; i++) {
            String name = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2.0) * height;

            if (volume > biggerKeg) {
                nameOfBiggest = name;
                biggerKeg = volume;
            }
        }
        System.out.println(nameOfBiggest);
    }
}
