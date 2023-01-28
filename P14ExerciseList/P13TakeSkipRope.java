package P14ExerciseList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P13TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        List<Integer> numbersList = new ArrayList<>();
        List<String> charactersList = new ArrayList<>();
        splitListToNumAndChar(inputList, numbersList, charactersList);
        List<Integer> skipList = new ArrayList<>();
        List<Integer> takeList = new ArrayList<>();
        splitToOddAndEven(numbersList, skipList, takeList);
        decriptMasage(takeList, skipList, inputList);

    }

    private static void decriptMasage(List<Integer> takeList, List<Integer> skipList, List<String> inputList) {
        int i = 0;
        String skip = "";
        String take = "";
        for (int getIndex = 0; getIndex < takeList.size(); getIndex++) {
            for (int j = i; j < i + takeList.get(getIndex); j++) {
                if (j < inputList.size()) {
                    take += inputList.get(j);
                }
            }
            i += takeList.get(getIndex);
            i += skipList.get(getIndex);
        }

        System.out.println(take);
    }

    private static void splitToOddAndEven(List<Integer> numbersList, List<Integer> skipList, List<Integer> takeList) {
        for (int i = 0; i < numbersList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbersList.get(i));
            }else {
                skipList.add(numbersList.get(i));
            }
        }
    }

    public static void splitListToNumAndChar(List<String> inputList, List<Integer> numbersList, List<String> characterList) {
        for (int i = 0; i < inputList.size(); i++) {
            char currentSymbol = inputList.get(i).charAt(0);
            if (currentSymbol >= 48 && currentSymbol <= 57) {
                numbersList.add(Integer.parseInt(inputList.get(i)));
            }else {
                characterList.add(inputList.get(i));
            }
        }
        for (int i = 0; i < inputList.size(); i++) {
            char currentSymbol = inputList.get(i).charAt(0);
            if (currentSymbol >= 48 && currentSymbol <= 57) {
                inputList.remove(i);
                i--;
            }
        }
    }
}
