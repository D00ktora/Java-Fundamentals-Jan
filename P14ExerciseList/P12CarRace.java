package P14ExerciseList;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P12CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> raceTrack = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int finishLineIndex = raceTrack.size() / 2;
        double leftPlayerTime = 0;
        double rightPlayerTime = 0;

        for (int leftPlayer = 0,  rightPlayer = raceTrack.size() - 1;
                leftPlayer < finishLineIndex && rightPlayer > finishLineIndex;
                leftPlayer++, rightPlayer--) {
            leftPlayerTime += raceTrack.get(leftPlayer);
            rightPlayerTime += raceTrack.get(rightPlayer);
            if (raceTrack.get(leftPlayer).equals(0)) {
                leftPlayerTime *= 0.8;
            }
            if (raceTrack.get(rightPlayer).equals(0)) {
                rightPlayerTime *= 0.8;
            }
        }

        if (leftPlayerTime < rightPlayerTime) {
            System.out.printf("The winner is left with total time: %.1f",leftPlayerTime);
        } else if (rightPlayerTime < leftPlayerTime) {
            System.out.printf("The winner is right with total time: %.1f",rightPlayerTime);
        }
    }
}
