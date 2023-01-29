/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 7:18
 */
package P16ExamPreparation2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String indexes = scanner.nextLine();
        int count = 0;
        while (!indexes.contains("End")) {
            int index = Integer.parseInt(indexes);
            if (isValidIndex(indexes, targets)) {
                int targetValue = targets.get(index);
                targets.set(index, -1);
                count++;
                modifyTargets(targets,targetValue);
            }
            indexes = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> %s",count, printTargets(targets));
    }

    private static String printTargets(List<Integer> targets) {
        List<String> arr = new ArrayList<>();
        for (Integer target : targets) {
            arr.add("" + target);
        }
        String temp = (String.join(" ", arr));
        return temp;
    }

    private static void modifyTargets(List<Integer> targets, int targetValue) {
        for (int i = 0; i < targets.size(); i++) {
            if (isValidIndex(String.valueOf(i), targets)) {
                if (targets.get(i) > targetValue) {
                    targets.set(i, targets.get(i) - targetValue);
                } else {
                    targets.set(i, targets.get(i) + targetValue);
                }
            }
        }
    }

    public static boolean isValidIndex(String indexes, List<Integer> targets) {
        int index = Integer.parseInt(indexes);
        if (index < 0) {
            return false;
        }
        if (index > targets.size() -1){
            return false;
        }
        if (targets.get(Integer.parseInt(indexes)) == -1) {
            return false;
        }
        return true;
    }
}
