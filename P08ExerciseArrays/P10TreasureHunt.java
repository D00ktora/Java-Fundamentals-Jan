package P08ExerciseArrays;

import java.util.Scanner;

public class P10TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[|]");
        String[] comands = scanner.nextLine().split(" ");
        String comand = comands[0];
        String[] comandsStr = new String[comands.length - 1];

//        for (int i = 1; i < comands.length; i++) {
//            comandsStr[i-1] = comands[i];
//        }

        while (!comand.equals("Yohoho!")) {

            switch (comand) {
                case "Loot":
                    for (int i = 1; i < comands.length; i++) {
                        comandsStr[i - 1] = comands[i];
                    }
                    String temp = "";
                    for (int i = 0; i < comandsStr.length; i++) {
                        String commandTemp = comandsStr[i];
                        boolean isAvailibe = false;
                        for (int j = 0; j < input.length; j++) {
                            if (commandTemp.equals(input[j])) {
                                isAvailibe = true;
                                break;
                            }
                        }
                        if (!isAvailibe) {
                            temp += comandsStr[i];
                            temp += " ";
                        }
                    }
                    String[] oneMoreArr = temp.split(" ");
                    temp = "";
                    for (int i = oneMoreArr.length - 1; i >= 0; i--) {
                        temp += oneMoreArr[i];
                        temp += " ";
                    }
                    comandsStr = temp.split(" ");

                    String[] arrStrFinal = new String[comandsStr.length + input.length];
                    temp = "";

                    for (int i = 0; i < comandsStr.length; i++) {
                        temp += comandsStr[i];
                        temp += " ";
                    }

                    for (int i = 0; i < input.length; i++) {
                        temp += input[i];
                        temp += " ";
                    }

                    input = temp.split(" ");

                    break;

                case "Drop":
                    if (comands.length < 2) {
                        break;
                    }
                    int index = Integer.parseInt(comands[1]);
                    if (index < 0 || index >= input.length){
                        break;
                    }
                    String tookOff = input[index];
                    String forSplit = "";
                    for (int i = 0; i < input.length; i++) {
                        if (i == index) {
                            continue;
                        }else {
                            forSplit += input[i];
                            forSplit += " ";
                        }
                    }

                    forSplit += tookOff;

                    input = forSplit.split(" ");
                    break;

                case "Steal":
                    int numberOfSteals = Integer.parseInt(comands[1]);
                    String stealSplit = "";
                    if (numberOfSteals > input.length) {
                        if (input.length == 0) {
                            break;
                        }
                        for (int i = 0; i < input.length - 1; i++) {
                            System.out.printf("%s, ",input[i]);
                        }
                        System.out.printf("%s%n", input[input.length - 1]);
                        input = new String[0];
                    } else {
                        int startingIndex = input.length - numberOfSteals;
                        for (int i = startingIndex; i < input.length - 1; i++) {
                            System.out.printf("%s, ",input[i]);
                        }
                        System.out.printf("%s%n", input[input.length - 1]);
                        for (int i = 0; i < input.length - numberOfSteals; i++) {
                            stealSplit += input[i];
                            stealSplit += " ";
                        }
                        input = stealSplit.split(" ");
                    }

                    break;
            }

            comands = scanner.nextLine().split(" ");
            comand = comands[0];

            }

        int lengthOfItem = 0;
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            lengthOfItem = input[i].length();
            sum += lengthOfItem;
        }

        int allItemsInChest = input.length;
        double average = (sum * 1.0) / (allItemsInChest * 1.0);
        if (input[0].equals("")){
            allItemsInChest = 0;
        }
        if (allItemsInChest < 1) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n",average);
        }
    }

}
