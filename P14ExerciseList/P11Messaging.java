package P14ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P11Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        String temp = "";
        for (int i = 0; i < integerList.size(); i++) {
            int sum = sumOfDigits(integerList.get(i));
            int indexesOfString = input.length() -1;
            if (sum > indexesOfString) {
                sum = findeGreatherIndex(sum, input, indexesOfString);
            } else if (sum < 0) {
                sum = findeSmallerIndex(sum, input, indexesOfString);
            }
            List<String> stringList = Arrays.stream(input.split("")).collect(Collectors.toList());
            temp += stringList.get(sum);
            stringList.remove(sum);
            input = String.join("", stringList);
        }

        System.out.println(temp);
    }

    private static int findeSmallerIndex(int sum, String input, int indexesOfString) {
        while (sum < 0) {
            sum += input.length();
        }
        return sum;
    }

    private static int findeGreatherIndex(int sum, String input, int indexesOfString) {
        while (sum > indexesOfString) {
            sum -= input.length();
        }
        return sum;
    }

    private static int sumOfDigits(Integer integer) {
        String number = String.valueOf(integer);
        String[] asArr = number.split("");
        int sum = 0;
        for (int i = 0; i < asArr.length; i++) {
            sum += Integer.parseInt(asArr[i]);
        }
        return sum;
    }
}
