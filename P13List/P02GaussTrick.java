package P13List;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < integerList.size() / 2; i++) {
            int sum = integerList.get(i) + integerList.get(integerList.size()-1-i);
            integerList.set(i,sum);
        }
        int forRemove = integerList.size() / 2;
        for (int i = 0; i < forRemove; i++) {
            integerList.remove(integerList.size() - 1);
        }

        for (int i = 0; i < integerList.size(); i++) {
            System.out.printf("%d ", integerList.get(i));
        }
    }
}
