package P14ExerciseList;

import java.util.*;
import java.util.stream.Collectors;

public class P14MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> startToEnd = new ArrayList<>();
        List<Integer> combinedList = new ArrayList<>();

        if (list1.size() > list2.size()) {
            startToEnd.add(list1.get(list1.size()-2));
            startToEnd.add(list1.get(list1.size()-1));
            list1.remove(list1.size()-1);
            list1.remove(list1.size()-1);
        } else {
            startToEnd.add(list2.get(0));
            startToEnd.add(list2.get(1));
            list2.remove(0);
            list2.remove(0);
        }

        for (int i = 0, j = list2.size()-1; i < list1.size(); i++, j--) {
            combinedList.add(list1.get(i));
            combinedList.add(list2.get(j));
        }

        int start = 0;
        int end = 0;
        if (startToEnd.get(0) > startToEnd.get(1)) {
            start = startToEnd.get(1);
            end = startToEnd.get(0);
        }else {
            start = startToEnd.get(0);
            end = startToEnd.get(1);
        }
        List<Integer> sordet = new ArrayList<>();
        for (int i = 0; i < combinedList.size(); i++) {
            int element = combinedList.get(i);
            if (element > start && element < end) {
                sordet.add(element);
            }
        }

        Collections.sort(sordet);
        for (Integer integer : sordet) {
            System.out.printf("%d ",integer);
        }
    }
}
