package P13List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String[] commands = scanner.nextLine().split(" ");
        String comand = commands[0];
        while (!comand.equals("end")){
            switch (comand) {
                case "Contains":
                    Integer containsNumber = Integer.parseInt(String.valueOf(commands[1]));
                    if (integerList.contains(containsNumber)) {
                        System.out.println("Yes");
                    }else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String subCommand = commands[1];
                    if (subCommand.equals("even")) {
                        for (Integer integer : integerList) {
                            if (integer % 2 == 0) {
                                System.out.printf("%d ", integer);
                            }
                        }
                        System.out.println();
                    } else if (subCommand.equals("odd")) {
                        for (Integer integer : integerList) {
                            if (!(integer % 2 == 0)) {
                                System.out.printf("%d ", integer);
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer integer : integerList) {
                        sum += integer;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String symbol = commands[1];
                    Integer numberFilter = Integer.parseInt(String.valueOf(commands[2]));
                    if (symbol.equals(">")) {
                        for (Integer integer : integerList) {
                            if (integer > numberFilter){
                                System.out.printf("%d ", integer);
                            }
                        }
                        System.out.println();
                    } else if (symbol.equals("<")) {
                        for (Integer integer : integerList) {
                            if (integer < numberFilter) {
                                System.out.printf("%d ", integer);
                            }
                        }
                        System.out.println();
                    } else if (symbol.equals(">=")) {
                        for (Integer integer : integerList) {
                            if (integer >= numberFilter) {
                                System.out.printf("%d ", integer);
                            }
                        }
                        System.out.println();
                    } else if (symbol.equals("<=")) {
                        for (Integer integer : integerList) {
                            if (integer <= numberFilter) {
                                System.out.printf("%d ",integer);
                            }
                        }
                        System.out.println();
                    }
                    break;
            }

            commands = scanner.nextLine().split(" ");
            comand = commands[0];
        }
    }
}
