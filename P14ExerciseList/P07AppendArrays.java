package P14ExerciseList;

import java.util.*;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrays = Arrays.asList(scanner.nextLine().split("[|]"));
        Collections.reverse(arrays);

        System.out.println(arrays.toString()
                .replace("[","")
                .replace("]","")
                .trim()
                .replaceAll(",","")
                .replaceAll("\\s+", " "));
    }
}
