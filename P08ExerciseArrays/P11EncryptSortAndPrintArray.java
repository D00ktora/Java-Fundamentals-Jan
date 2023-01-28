package P08ExerciseArrays;

import java.util.Scanner;

public class P11EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int[] numbArr = new int[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            String name = scanner.nextLine();
            int sumOfTheString = 0;
            for (int j = 0; j < name.length(); j++) {
                char symbol = name.charAt(j);
                if (symbol == 'A' || symbol == 'a' || symbol == 'E' || symbol == 'e' || symbol == 'I' || symbol == 'i' ||
                        symbol == 'O' || symbol == 'o' || symbol == 'U' || symbol == 'u') {
                    sumOfTheString += symbol * name.length();
                }else {
                    sumOfTheString += symbol / name.length();
                }
            }
            numbArr[i] = sumOfTheString;
        }

        for (int i = 0; i < numbArr.length - 1; i++) {
            for (int j = 0; j < numbArr.length - 1; j++) {
                int temp = numbArr[i];
                if (numbArr[j] > numbArr[j + 1]) {
                    temp = numbArr[j];
                    numbArr[j] = numbArr[j+1];
                    numbArr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < numbArr.length; i++) {
            System.out.println(numbArr[i]);
        }
    }
}
//4
//Peter
//Maria
//Katya
//Todor


//3
//Sofia
//London
//Washingto