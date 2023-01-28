package P08ExerciseArrays;

import java.util.Scanner;

public class P15KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sqLength = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();
        String[] input = text.split("!+");
        String[] longest = new String[sqLength];
        int sqStart = 0;
        int sumOfElements = 0;
        int sum = 0;
        int sampleCounter = 1;
        int witchSample = 1;

        while (!text.equals("Clone them!")) {
            int tempSumOfElements = 0;
            int tempSqStart = 0;
            int tempSum = 0;
            for (int i = 0; i < input.length - 1; i++) {
                int temptempElements = 0;
                int temptempStart = 0;
                if (input[i].equals("1") && input[i+1].equals("1")) {
                    temptempElements++;
                    temptempStart = i;
                    if (temptempElements > tempSumOfElements) {
                        tempSumOfElements = temptempElements;
                    }
                    if (temptempStart > tempSqStart) {
                        tempSqStart = temptempStart;
                    }
                } else {
                    temptempStart = 0;
                    temptempElements = 0;
                }

                if (input[i].equals("1")) {
                    tempSum++;
                }
            }
            if (input[input.length-1].equals("1"))
                tempSum++;

            if (tempSumOfElements > sumOfElements) {
                sumOfElements = tempSumOfElements;
                sqStart = tempSqStart;
                longest = input;
                sum = tempSum;
                witchSample = sampleCounter;
            } else if (tempSumOfElements == sumOfElements) {
                if (tempSqStart < sqStart) {
                    sumOfElements = tempSumOfElements;
                    sqStart = tempSqStart;
                    longest = input;
                    sum = tempSum;
                    witchSample = sampleCounter;
                } else if (tempSqStart == sqStart) {
                    if (tempSum > sum) {
                        sumOfElements = tempSumOfElements;
                        sqStart = tempSqStart;
                        longest = input;
                        sum = tempSum;
                        witchSample = sampleCounter;
                    }
                }
            }
            text = scanner.nextLine();
            input = text.split("!+");
            sampleCounter++;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n",witchSample, sum);
        System.out.println(String.join(" ", longest));
    }
}
