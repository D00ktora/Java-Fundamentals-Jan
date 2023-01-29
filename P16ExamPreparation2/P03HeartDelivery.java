/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 17:19
 */
package P16ExamPreparation2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> neighborhood = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        AtomicInteger cupidonLastPosition = new AtomicInteger(0);
        while (!command.contains("Love!")) {
            int temp = Integer.parseInt(command.split(" ")[1]);
            AtomicInteger newPosition = new AtomicInteger(temp);      //Integer.parseInt(command.split(" ")[1]);
            findNewPos(neighborhood,newPosition,cupidonLastPosition);
            leaveHearts(neighborhood,newPosition);
            cupidonLastPosition = newPosition;
            command = scanner.nextLine();
        }
        int temp = howManyHouses(neighborhood);
        if (isAllHousesInLove(neighborhood)) {
            System.out.printf("Cupid's last position was %d.%n",cupidonLastPosition.get());
            System.out.println("Mission was successful.");
        }else {
            System.out.printf("Cupid's last position was %d.%n",cupidonLastPosition.get());
            System.out.printf("Cupid has failed %d places.", temp);
        }
    }
    public static void findNewPos (List<Integer> neighborhood, AtomicInteger newPosition, AtomicInteger lastPosition) {
        int neighborhoodSize = neighborhood.size();
        if (newPosition.get() + lastPosition.get() >= neighborhoodSize) {
            newPosition.set(0);
        } else {
            newPosition.set(newPosition.get() + lastPosition.get());
        }
    }
//    public static void leaveHearts (List<Integer> neighborhood, AtomicInteger newPosition) {
//        if (neighborhood.get(newPosition.get()) > 2) {
//            neighborhood.set(newPosition.get(), neighborhood.get(newPosition.get()) - 2);
//        } else if (neighborhood.get(newPosition.get()).equals(2)) {
//            neighborhood.set(newPosition.get(), 0);
//            System.out.printf("Place %d has Valentine's day.%n", newPosition.get());
//        } else if (neighborhood.get(newPosition.get()).equals(0)) {
//            System.out.printf("Place %d already had Valentine's day.%n", newPosition.get());
//        }
//    }

    public static void leaveHearts (List<Integer> neighborhood, AtomicInteger newPosition) {
        if (!neighborhood.get(newPosition.get()).equals(0)) {
            neighborhood.set(newPosition.get(), neighborhood.get(newPosition.get()) - 2);
            if (neighborhood.get(newPosition.get()).equals(0)){
                System.out.printf("Place %d has Valentine's day.%n", newPosition.get());
            }
        }
        else {
            System.out.printf("Place %d already had Valentine's day.%n", newPosition.get());
        }
    }

    public static boolean isAllHousesInLove (List<Integer> neighborhood) {
        for (Integer integer : neighborhood) {
            if (!integer.equals(0)){
                return false;
            }
        }
        return true;
    }

    public static int howManyHouses(List<Integer> neighborhood) {
        int temp = 0;
        for (Integer integer : neighborhood) {
            if (integer != 0) {
                temp++;
            }
        }
        return temp;
    }
}
