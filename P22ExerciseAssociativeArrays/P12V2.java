/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 11.2.2023 г.
 * Time: 9:51
 */
package P22ExerciseAssociativeArrays;

import com.sun.source.tree.Tree;

import java.util.*;

public class P12V2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> judge = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> totalSubmitions = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        String text = scanner.nextLine();

        while (!text.contains("no more time")) {
            String contest = text.split(" -> ")[1];
            String name = text.split(" -> ")[0];
            int points = Integer.parseInt(text.split(" -> ")[2]);
            boolean needUpdate = false;
            if (judge.containsKey(contest)) {
                LinkedHashMap<String, Integer> tempMap = judge.get(contest);
                if (tempMap.containsKey(name)) {
                    int currentValue = tempMap.get(name);
                    if (currentValue < points) {
                        currentValue = points;
                        tempMap.put(name, currentValue);
                        judge.put(contest,tempMap);
                        needUpdate = true;
                    }
                } else {
                    //tempMap = new LinkedHashMap<>();
                    tempMap.put(name,points);
                    judge.put(contest,tempMap);
                }
            } else {
                LinkedHashMap<String, Integer> tempMap = new LinkedHashMap<>();
                tempMap.put(name,points);
                judge.put(contest,tempMap);
            }

            if (totalSubmitions.containsKey(name)) {
                if (!needUpdate) {
                    int currentValue = totalSubmitions.get(name);
                    currentValue += points;
                    totalSubmitions.put(name, currentValue);
                }else {
                    int currentValue = totalSubmitions.get(name);
                    if (currentValue < points) {
                        currentValue = points;
                        totalSubmitions.put(name,currentValue);
                    }
                }
            } else {
                totalSubmitions.put(name,points);
            }
            text = scanner.nextLine();
        }


        for (Map.Entry<String, LinkedHashMap<String, Integer>> contest : judge.entrySet()) {
            LinkedHashMap<String,Integer> names = contest.getValue();
            String nameOfContest = contest.getKey();
            LinkedHashMap<String,Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : names.entrySet()) {
                list.add(entry.getValue());
            }
            Collections.sort(list);
            Collections.reverse(list);
            for (int num : list) {
                for (Map.Entry<String, Integer> entry : names.entrySet()) {
                    if (entry.getValue().equals(num)) {
                        sortedMap.put(entry.getKey(), num);
                    }
                }
            }
            judge.put(nameOfContest, sortedMap);
        }


        LinkedHashMap<String, Integer> sortedMapTotal = new LinkedHashMap<>();
        List<Integer> integerList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : totalSubmitions.entrySet()) {
            integerList.add(entry.getValue());
        }
        Collections.sort(integerList);
        Collections.reverse(integerList);
        for (int num : integerList) {
            for (Map.Entry<String, Integer> entry : totalSubmitions.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMapTotal.put(entry.getKey(), num);
                }
            }
        }




        for (Map.Entry<String,LinkedHashMap<String,Integer>> contest : judge.entrySet()) {
            LinkedHashMap<String, Integer> names = contest.getValue();
            System.out.printf("%s: %d participants%n",contest.getKey(), contest.getValue().size());
            int i = 1;
            for (Map.Entry<String, Integer> name : names.entrySet()) {
                System.out.printf("%d. %s <::> %d%n",i,name.getKey(),name.getValue());
                i++;
            }
        }
        System.out.println("Individual standings:");
        int i = 1;
        for (Map.Entry<String, Integer> sortedNames : sortedMapTotal.entrySet()) {
            System.out.printf("%d. %s -> %d%n",i,sortedNames.getKey(),sortedNames.getValue());
            i++;
        }


    }
}
