package P14ExerciseList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P15DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> garySavings = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());
        List<Integer> initialQuality = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> startingQuality = new ArrayList<>();
        for (int i = 0; i < initialQuality.size(); i++) {
            startingQuality.add(initialQuality.get(i));
        }
        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            applyPower(hitPower,initialQuality);
            List<Integer> indexesForReplacement = new ArrayList<>();
            forReplacement(initialQuality, indexesForReplacement);
            buyOrRemove(initialQuality, indexesForReplacement, startingQuality, garySavings);
            input = scanner.nextLine();
        }

        printArray(initialQuality, garySavings);
    }

    private static void printArray(List<Integer> initialQuality, List<Double> garySavings) {
        for (Integer integer : initialQuality) {
            System.out.printf("%d ", integer);
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.",garySavings.get(0));
    }

    public static void applyPower(int hitPower, List<Integer> initialQuality) {
        for (int i = 0; i < initialQuality.size(); i++) {
            initialQuality.set(i, initialQuality.get(i) - hitPower);
        }
    }

    public static void forReplacement(List<Integer> initialQuality, List<Integer> indexesForReplacement){
        for (int i = 0; i < initialQuality.size(); i++) {
            if (initialQuality.get(i) <= 0) {
                indexesForReplacement.add(i);
            }
        }
    }

    public static void buyOrRemove(List<Integer> initialQuality, List<Integer> indexesForReplacement, List<Integer> startingQuality, List<Double> garySavings) {
        for (int i = 0; i < indexesForReplacement.size(); i++) {
            double neededMoney = startingQuality.get(indexesForReplacement.get(i)) * 3.0;
            if (garySavings.get(0) >= neededMoney) {
                garySavings.set(0, garySavings.get(0) - neededMoney);
                initialQuality.set(indexesForReplacement.get(i),startingQuality.get(indexesForReplacement.get(i)));
            } else {
                initialQuality.set(indexesForReplacement.get(i), -9999);
                startingQuality.set(indexesForReplacement.get(i), -9999);
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(-9999);
        initialQuality.removeAll(temp);
        startingQuality.removeAll(temp);
    }
}
