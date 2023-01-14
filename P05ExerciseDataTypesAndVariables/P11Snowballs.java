package P05ExerciseDataTypesAndVariables;

import java.math.BigInteger;
import java.util.Scanner;

public class P11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int numberOfBolls = Integer.parseInt(scanner.nextLine());
//        int biggestBoll = 0;
//        int forPrintFirst = 0;
//        int forPrintSecond = 0;
//        int forPrintLast = 0;
//        for (int i = 0; i < numberOfBolls; i++) {
//            int snow = Integer.parseInt(scanner.nextLine());
//            int time = Integer.parseInt(scanner.nextLine());
//            int quality = Integer.parseInt(scanner.nextLine());
//
//            int valueOfBollDevided = snow / time;
//            int endValueOfBoll = (int) Math.pow(valueOfBollDevided, quality);
//
//            if (endValueOfBoll >= biggestBoll) {
//                biggestBoll = endValueOfBoll;
//                forPrintFirst = snow;
//                forPrintSecond = time;
//                forPrintLast = quality;
//            }
//        }
//
//        System.out.printf("%d : %d = %d (%d)", forPrintFirst, forPrintSecond, biggestBoll, forPrintLast);



        int numberOfBolls = Integer.parseInt(scanner.nextLine());
        BigInteger biggestBoll = BigInteger.valueOf(0);
        int forPrintFirst = 0;
        int forPrintSecond = 0;
        int forPrintLast = 0;
        for (int i = 0; i < numberOfBolls; i++) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());

            BigInteger valueOfBollDevided = BigInteger.valueOf(snow).divide(BigInteger.valueOf(time));
            valueOfBollDevided = valueOfBollDevided.pow(quality);

            if (valueOfBollDevided.longValue() >= biggestBoll.longValue()) {
                biggestBoll = valueOfBollDevided;
                forPrintFirst = snow;
                forPrintSecond = time;
                forPrintLast = quality;
            }
        }

        System.out.printf("%d : %d = %d (%d)", forPrintFirst, forPrintSecond, biggestBoll, forPrintLast);
    }
}
