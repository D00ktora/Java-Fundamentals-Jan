/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 28.1.2023 г.
 * Time: 13:53
 */
package P16ExamPreparation2;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Double> result = new ArrayList<>();

        double average = findeTheAverageValue(integerList);
        searchForTop5(integerList, result, average);
        Collections.sort(result);
        Collections.reverse(result);
        printResult(result);
    }

    private static void printResult(List<Double> result) {
        if (result.size() <= 5) {
            for (Double aDouble : result) {
                System.out.printf("%.0f ", aDouble);
            }
        }else {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%.0f ", result.get(i));
            }
        }
        if (result.size() == 0) {
            System.out.println("No");
        }
    }

    private static void searchForTop5(List<Integer> integerList, List<Double> result, double average) {
        for (Integer integer : integerList) {
            if (integer > average) {
                result.add(Double.valueOf(integer));
            }
        }
    }

    private static double findeTheAverageValue(List<Integer> integerList) {
        double sum = 0;
        for (Integer integer : integerList) {
            sum += integer;
        }
        sum *= 1.0;
        sum /= integerList.size();
        return sum;
    }
}
