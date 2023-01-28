package P10Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("-")) {
                input[i + 1] = input[i] + input[i + 1];
                int number = Integer.parseInt(String.valueOf(input[i + 1]));
                numbers.add(Math.abs(number));
                i++;
                continue;
            }
            numbers.add(Integer.parseInt(String.valueOf(input[i])));


        }
//        int result = number(numbers);
        System.out.println(number(numbers));
    }

    private static int number(List<Integer> numbers) {
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                sumEven += numbers.get(i);
            } else {
                sumOdd += numbers.get(i);
            }
        }

        return sumEven * sumOdd;
    }
}
