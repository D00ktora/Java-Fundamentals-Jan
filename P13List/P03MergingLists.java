package P13List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> integerList2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int biggestList;
        int smallestList;
        if (integerList1.size() > integerList2.size()) {
            biggestList = integerList1.size();
            smallestList = integerList2.size();
        } else  {
            biggestList = integerList2.size();
            smallestList = integerList1.size();
        }
        List<Integer> joinedLists = new ArrayList<>();
        for (int i = 0; i < biggestList; i++) {
            if (i < smallestList) {
                joinedLists.add(integerList1.get(i));
                joinedLists.add(integerList2.get(i));
            } else {
                if (integerList1.size() > integerList2.size()) {
                    joinedLists.add(integerList1.get(i));
                } else {
                    joinedLists.add(integerList2.get(i));
                }
            }
        }

        for (Integer joinedList : joinedLists) {
            System.out.printf("%d ",joinedList);
        }
    }
}
