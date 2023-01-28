package P13List;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i).equals(integerList.get(i+1))) {
                double sum = integerList.get(i) + integerList.get(i + 1);
                integerList.set(i, sum);
                integerList.remove(i + 1);
                i = - 1;
            }
        }

        for (Double integer : integerList) {
            System.out.printf(new DecimalFormat("0.#").format(integer) + " ");
        }
    }
}
