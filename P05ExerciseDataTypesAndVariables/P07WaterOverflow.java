package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int iterations = Integer.parseInt(scanner.nextLine());
        int tankCapacity = 255;
        int tankIsFillWith = 0;
        for (int i = 0; i <iterations; i++) {
            int liters = Integer.parseInt(scanner.nextLine());
            if (tankCapacity - liters >= 0) {
                tankIsFillWith += liters;
                tankCapacity -= liters;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(tankIsFillWith);
    }
}
