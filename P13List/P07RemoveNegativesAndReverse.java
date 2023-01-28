package P13List;

import java.util.*;
import java.util.stream.Collectors;

public class P07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < integerList.size(); i++) {
            if (integerList.get(i) < 0) {
                integerList.remove(i);
                i--;
            }
        }

        Collections.reverse(integerList);

        if (!integerList.isEmpty()) {
            for (Integer integer : integerList) {
                System.out.printf("%d ",integer);
            }
        } else {
            System.out.println("empty");
        }
    }
}
