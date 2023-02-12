/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 11.2.2023 г.
 * Time: 8:00
 */
package P22ExerciseAssociativeArrays;

import java.util.*;

public class P12Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        String text = scanner.nextLine();

        //read the input from console
        while (!text.contains("no more time")) {
            String inputText = text;
            input.add(inputText);
            text = scanner.nextLine();
        }

        LinkedHashMap<String, Integer> contestMap = new LinkedHashMap<>();
        fullContestMap(input, contestMap);

        TreeMap<String, List<String>> namesMap = new TreeMap<>();
        fullContestNames(contestMap,input,namesMap);

        LinkedHashMap<String, List<Integer>> pointsMap = new LinkedHashMap<>();
        fullContestPoints(pointsMap, input, namesMap, contestMap);
        for (List<Integer> value : pointsMap.values()) {
            Collections.sort(value);
            Collections.reverse(value);
        }

        LinkedHashMap<String, LinkedHashMap<String,Integer>> combinedMap = new LinkedHashMap<>();
        combineAllMaps(combinedMap, pointsMap, namesMap, contestMap, input);


        System.out.printf("");
    }

    private static void combineAllMaps(LinkedHashMap<String, LinkedHashMap<String, Integer>> combinedMap, LinkedHashMap<String, List<Integer>> pointsMap, TreeMap<String, List<String>> namesMap, LinkedHashMap<String, Integer> contestMap, List<String> input) {
        for (String contest : contestMap.keySet()) {
            List<String> names = namesMap.get(contest);
            for (String name : names) {
                List<Integer> points = pointsMap.get(name);
                for (Integer point : points) {
                    for (String in : input) {
                        String inputContest = in.split(" -> ")[1];
                        String inputName = in.split(" -> ")[0];
                        int inputPoints = Integer.parseInt(in.split(" -> ")[2]);
                        //if ()
                    }
                }
            }
        }
    }

    private static void fullContestPoints(LinkedHashMap<String, List<Integer>> pointsMap, List<String> input, TreeMap<String, List<String>> namesMap, LinkedHashMap<String, Integer> contestMap) {
        for (String in : input) {
            String name = in.split(" -> ")[0];
            int value = Integer.parseInt(in.split(" -> ")[2]);
            if (pointsMap.containsKey(name)) {
                List<Integer> tempIntList = pointsMap.get(name);
                tempIntList.add(value);
                pointsMap.put(name,tempIntList);
            }else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(value);
                pointsMap.put(name,tempList);
            }
        }
    }


    private static void fullContestNames(LinkedHashMap<String, Integer> contestMap, List<String> input, TreeMap<String, List<String>> namesMap) {
        for (String contest : contestMap.keySet()) {
            for (String in : input) {
                String cont = in.split(" -> ")[1];
                String name = in.split(" -> ")[0];
                if (namesMap.containsKey(cont)) {
                    if (!namesMap.get(cont).contains(name)) {
                        List<String> tempContList = namesMap.get(cont);
                        tempContList.add(name);
                        namesMap.put(cont, tempContList);
                    }
                } else {
                    List<String> tempContList = new ArrayList<>();
                    tempContList.add(name);
                    namesMap.put(cont, tempContList);
                }
            }
        }
    }

    private static void fullContestMap(List<String> input, LinkedHashMap<String, Integer> contestMap) {
        for (String s : input) {
            String contest = s.split(" -> ")[1];
            if (contestMap.containsKey(contest)) {
                int updateValue = contestMap.get(contest);
                updateValue++;
                contestMap.put(contest, updateValue);
            } else {
                contestMap.put(contest, 1);
            }
        }
    }
}
