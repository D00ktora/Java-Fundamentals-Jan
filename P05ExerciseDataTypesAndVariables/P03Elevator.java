package P05ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeoples = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        while (numberOfPeoples - elevatorCapacity > 0) {
            int temp = numberOfPeoples - elevatorCapacity;
                sum ++;
                numberOfPeoples -= elevatorCapacity;
        }
        if (numberOfPeoples > 0){
            sum++;
        }
        System.out.println(sum);
    }
}
