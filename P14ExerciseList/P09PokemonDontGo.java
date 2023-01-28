package P14ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //You will receive a sequence of integers, separated by spaces - the distances to the Pokémons.
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //Then you will begin receiving integers corresponding to indexes in that sequence.
        int index = Integer.parseInt(scanner.nextLine());
        int sumOfRemovedElements = 0;
        while (true) {

            //If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
            if (index < 0) {
                int removedElementValue = integerList.get(0);
                sumOfRemovedElements += removedElementValue;
                integerList.set(0, integerList.get(integerList.size() - 1));
                modifyTheList(integerList, removedElementValue);
            }

            //If the given index is GREATER than the last index of the sequence, remove the last element from the sequence, and COPY the first element to its place.
            else if (index > integerList.size() - 1) {
                int removedElementValue = integerList.get(integerList.size() - 1);
                sumOfRemovedElements += removedElementValue;
                integerList.set(integerList.size() - 1, integerList.get(0));
                modifyTheList(integerList, removedElementValue);
            }

            //When you receive an index, you must remove the element at that index from the sequence (as if you've captured the Pokémon).
            else if (index >= 0 && index <= integerList.size() - 1){
                int removedElementValue = integerList.get(index);
                sumOfRemovedElements += removedElementValue;
                integerList.remove(index);
                modifyTheList(integerList, removedElementValue);
            }
            if (integerList.size() > 0) {
                index = Integer.parseInt(scanner.nextLine());
            } else {break;}
        }
        System.out.println(sumOfRemovedElements);
    }

    public static void modifyTheList (List<Integer> integerList, int removedElementValue) {
        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) <= removedElementValue) {
                int temp = integerList.get(i);
                integerList.set(i, temp + removedElementValue);
            } else if (integerList.get(i) > removedElementValue) {
                int temp = integerList.get(i);
                integerList.set(i, temp - removedElementValue);
            }
        }
    }
}
