package P14ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagonPassangers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String comands = scanner.nextLine();

        while (!comands.equals("end")){
            String[] comandsTemp = comands.split(" ");
            String comand = comandsTemp[0];

            switch (comand){
                case "Add":
                    int numberOfPpl = Integer.parseInt(String.valueOf(comandsTemp[1]));
                    wagonPassangers.add(numberOfPpl);
                    break;
                default:
                    int addPPl = Integer.parseInt(String.valueOf(comand));
                    for (int i = 0; i < wagonPassangers.size(); i++) {
                        if (wagonPassangers.get(i) + addPPl <= maxCapacity){
                            int updateValue = wagonPassangers.get(i) + addPPl;
                            wagonPassangers.set(i, updateValue);
                            break;
                        }
                    }
            }
            comands = scanner.nextLine();
        }
        for (Integer wagonPassanger : wagonPassangers) {
            System.out.printf("%d ", wagonPassanger);
        }
    }
}
//32 54 21 12 4 0 23
//75
//Add 10
//Add 0
//30
//10
//75
//end

//0 0 0 10 2 4
//10
//Add 10
//10
//10
//10
//8
//6
//end