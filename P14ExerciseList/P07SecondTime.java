/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 24.1.2023 г.
 * Time: 6:17
 */
package P14ExerciseList;

import java.util.*;
import java.util.stream.Collectors;

public class P07SecondTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrays = scanner.nextLine().split("[|]");
        List<List<String>> listList = new ArrayList<>();

        for (int i = 0; i < arrays.length; i++) {
            String tempString = arrays[i];
            tempString = tempString.trim();
            if (tempString.equals("")){
                continue;
            }
            List<String> temp = Arrays.stream(tempString.split("\\s+")).collect(Collectors.toList());
            listList.add(temp);
        }

        Collections.reverse(listList);

        for (List<String> integerList : listList) {
            for (String integer : integerList) {
                System.out.printf("%s ", integer);
            }
        }
    }
}
