package P08ExerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P16LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] bugPosition = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] field = new int[fieldSize];
        String newPosition = "";
        String moveTo = "";
        int bugOnIndex = 0;
        int movementSpeed = 0;

        for (int i = 0; i < bugPosition.length; i++) {
            if (bugPosition[i] < 0 || bugPosition[i] > fieldSize - 1) {
                continue;
            } else {
                newPosition += bugPosition[i];
                newPosition += " ";
            }
        }
        bugPosition = Arrays.stream(newPosition.split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < bugPosition.length; i++) {
            field[bugPosition[i]] = 1;
        }

        String[] comand = scanner.nextLine().split(" ");
        if (!comand[0].equals("end")){
            bugOnIndex = Integer.parseInt(comand[0]);
            moveTo = comand[1];
            movementSpeed = Integer.parseInt(comand[2]);
        }

        while (!comand[0].equals("end")) {

        boolean isNextPositionFree = false;
        boolean isOutOfField = false;
        boolean findFreePosition = false;
        if (moveTo.equals("left")) {
//            if (field[bugOnIndex] == 1){
//                while (!findFreePosition) {
//                    if (!(bugOnIndex - movementSpeed <= 0)) {
//                        if (field[bugOnIndex - movementSpeed] == 0){
//                            field[bugOnIndex] = 0;
//                            field[bugOnIndex - movementSpeed] = 1;
//                            findFreePosition = true;
//                        }
//                    }
//                }
//            }
            if (field[bugOnIndex] == 1){
                int tempBugIntex = bugOnIndex;
                while (!findFreePosition) {
                    if (!(tempBugIntex - movementSpeed <= 0)) {
                        if (field[tempBugIntex - movementSpeed] == 0){
                            field[bugOnIndex] = 0;
                            field[tempBugIntex - movementSpeed] = 1;
                            findFreePosition = true;
                        } else {
                            tempBugIntex++;
                        }
                    } else {
                        field[bugOnIndex] = 0;
                        break;
                    }
                }
            }
        } else if (moveTo.equals("right")) {
            if (field[bugOnIndex] == 1){
                int tempBugIntex = bugOnIndex;
                while (!findFreePosition) {
                    if ((tempBugIntex + movementSpeed <= field.length - 1)) {
                        if (field[tempBugIntex + movementSpeed] == 0){
                            field[bugOnIndex] = 0;
                            field[tempBugIntex + movementSpeed] = 1;
                            findFreePosition = true;
                        } else {
                            tempBugIntex++;
                        }
                    } else {
                        field[bugOnIndex] = 0;
                        break;
                    }
                }
            }
        }

            comand = scanner.nextLine().split(" ");
            if (!comand[0].equals("end")){
                bugOnIndex = Integer.parseInt(comand[0]);
                moveTo = comand[1];
                movementSpeed = Integer.parseInt(comand[2]);
            }
        }
        for (int i = 0; i < field.length; i++) {
            System.out.printf("%d ", field[i]);
        }
    }
}
