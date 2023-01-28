/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 9:09
 */
package P16ExamPreparation2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;
import java.util.stream.Collectors;

public class P02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pplWaiting = Integer.parseInt(scanner.nextLine());
        List<Integer> lift = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        if (isAvailibleSpace(lift)) {
            for (int i = 0; i < lift.size(); i++) {
                if (lift.get(i) < 4) {
                    int pplToAdd = 0;
                    if (pplWaiting >= 4) {
                        pplToAdd = Math.abs(lift.get(i) - 4);
                    } else {
                        pplToAdd = pplWaiting;
                    }
                    pplWaiting -= 4 - lift.get(i);
                    lift.set(i, lift.get(i) + pplToAdd);
                } else if (lift.get(i) == 4) {
                    continue;
                }
                if (pplWaiting < 0) {
                    pplWaiting = 0;
                }
            }
        }

        if (pplWaiting <= 0) {
            if (pplWaiting <0) {
                pplWaiting = 0;
            }
            else if (isAvailibleSpace(lift)){
                System.out.println("The lift has empty spots!");
                printList(lift);
            }else if ( pplWaiting == 0) {
                printList(lift);
            }
        }else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", pplWaiting);
            printList(lift);
        }
    }

    public static boolean isAvailibleSpace(List<Integer> lift) {
        for (Integer integer : lift) {
            if (integer < 4) {
                return true;
            }
        }
        return false;
    }

    public static void printList(List<Integer> lift) {
        for (Integer integer : lift) {
            System.out.printf("%d ", integer);
        }
        System.out.println();
    }
}
