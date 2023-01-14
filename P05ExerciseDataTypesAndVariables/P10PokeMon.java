package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        double startingPower = power * 0.5;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaust = Integer.parseInt(scanner.nextLine());
        int counter = 0;


        while (power >= distance) {
                    power -= distance;
                    counter++;
                    double percentOfPower = power * 0.5;
                    if (power == startingPower) {
                        if (exhaust != 0 && power / exhaust > 0) {
                            power /= exhaust;
                        }
                    }
        }
        System.out.println(power);
        System.out.println(counter);
    }
}
