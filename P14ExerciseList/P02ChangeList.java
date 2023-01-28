package P14ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();
        //String command = commands[0].toLowerCase();
        while (!commands.contains("end")){
//            switch (command){
//                case "delete":
//                    Integer element = Integer.parseInt(String.valueOf(commands[1]));
//                    for (int i = 0; i < integerList.size(); i++) {
//                        int elementTemp = integerList.get(i);
//                        if (elementTemp == element) {
//                            integerList.remove(i);
//                            i = -1;
//                        }
//                    }
//                    break;
//                case "insert":
//                    element = Integer.parseInt(String.valueOf(commands[1]));
//                    int position = Integer.parseInt(String.valueOf(commands[2]));
//                    if (position >= 0 && position <= integerList.size()-1) {
//                        integerList.add(position, element);
//                    }
//                    break;
//            }
            if (commands.contains("Delete")) {
                int numberToRemove = Integer.parseInt(commands.split(" ")[1]);
                integerList.removeAll(Arrays.asList(numberToRemove));
            } else if (commands.contains("Insert")) {
                int numberToInsert = Integer.parseInt(commands.split(" ")[1]);
                int index = Integer.parseInt(commands.split(" ")[2]);
                integerList.add(index, numberToInsert);
            }
            commands = scanner.nextLine();
        }

        for (Integer integer : integerList) {
            System.out.printf("%d ", integer);
        }
        if (integerList.isEmpty()) {
            System.out.println(0);
        }
    }
}
//1 2 3 4 5 5 5 6
//Delete 5
//Insert 10 1
//Delete 5
//end


//20 12 4 319 21 31234 2 41 23 4
//Insert 50 2
//Insert 50 5
//Delete 4
//end