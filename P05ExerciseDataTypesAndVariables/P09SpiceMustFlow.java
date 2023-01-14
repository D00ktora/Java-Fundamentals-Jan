package P05ExerciseDataTypesAndVariables;

import java.math.BigInteger;
import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger startingYield = BigInteger.valueOf(Long.parseLong(scanner.nextLine()));
        int numberOfDays = 0;
        BigInteger collectedSeeds = BigInteger.valueOf(0);
        BigInteger max = BigInteger.valueOf(100);
        while (startingYield.longValue() >= 100) {

            BigInteger rest = startingYield.subtract(BigInteger.valueOf(26));
            collectedSeeds = collectedSeeds.add(rest);
            startingYield = startingYield.subtract(BigInteger.valueOf(10));
            numberOfDays++;

        }

        if (collectedSeeds.equals(0)) {
            collectedSeeds = startingYield.subtract(BigInteger.valueOf(26));
        }else {
            collectedSeeds = collectedSeeds.subtract(BigInteger.valueOf(26)) ;
        }
        if (collectedSeeds.longValue() < 0){
            collectedSeeds = BigInteger.valueOf(0);
        }
        System.out.println(numberOfDays);
        System.out.println(collectedSeeds);
    }
}


//            int rest = startingYield - 26;
//            collectedSeeds += rest;
//            startingYield -= 10;
//            numberOfDays++;

//