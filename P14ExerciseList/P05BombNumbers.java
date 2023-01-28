package P14ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        Integer bomb = Integer.parseInt(command.split(" ")[0]);
        int range = Integer.parseInt(command.split(" ")[1]);

        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);
            boolean isInLeftRange = index - range >= 0;
            boolean isInRightRange = index + range <= numbers.size() - 1;
            if (isInLeftRange){
                for (int i = index; i >= index - range; i--) {
                    numbers.set(i,0);
                }
            }else {
                for (int i = index; i >= 0; i--) {
                    numbers.set(i, 0);
                }
            }

            if (isInRightRange) {
                for (int i = index; i <= index + range; i++) {
                    numbers.set(i, 0);
                }
            }else {
                for (int i = index; i <= numbers.size() - 1; i++) {
                    numbers.set(i, 0);
                }
            }
            //1. Трябва да премахна всички (или по-добре да ги направя 0-ли и след това да премахна всички 0-ли) от индекса до ренджа на ляво, без индекса.
            //2. Трябва да премахна всички (или по-добре да ги направя 0-ли и след това да премахна всички 0-ли) от индекса до ренджа на дясно, без индекса.
            //3. Премахвам и индекса (или по-добре да ги направя 0-ли и след това да премахна всички 0-ли).
            int numberToRemove = 0;
            numbers.removeAll(Arrays.asList(numberToRemove));
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        System.out.println(sum);
    }
}
