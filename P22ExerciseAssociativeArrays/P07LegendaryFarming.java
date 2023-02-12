/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 18:52
 */
package P22ExerciseAssociativeArrays;


import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class P07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> materialHashMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> junkHashMap = new LinkedHashMap<>();
        int shards = 0;
        int motes = 0;
        int fragments = 0;
        boolean isTrue = false;
        materialHashMap.put("shards", 0);
        materialHashMap.put("fragments", 0);
        materialHashMap.put("motes", 0);

        while (!isTrue) {
            String[] inputArr = input.split("\\s+");
            for (int i = 0; i < inputArr.length; i += 2) {
                String material = inputArr[i + 1].toLowerCase(Locale.ROOT);
                int qty = Integer.parseInt(inputArr[i]);

                if (material.equals("shards") || material.equals("motes") || material.equals("fragments")) {
                    if (!materialHashMap.containsKey(material)) {
                        materialHashMap.put(material, qty);
                    } else {
                        int currentQty = materialHashMap.get(material);
                        currentQty += qty;
                        materialHashMap.put(material, currentQty);
                    }
                } else {
                    if (!junkHashMap.containsKey(material)) {
                        junkHashMap.put(material, qty);
                    } else {
                        int currentQty = junkHashMap.get(material);
                        currentQty += qty;
                        junkHashMap.put(material, currentQty);
                    }
                }
                if (material.equals("shards")) {
                    shards += qty;
                    if (shards >= 250 || motes >= 250 || fragments >= 250) {
                        isTrue = true;
                        break;
                    }
                } else if (material.equals("motes")) {
                    motes += qty;
                    if (shards >= 250 || motes >= 250 || fragments >= 250) {
                        isTrue = true;
                        break;
                    }
                } else if (material.equals("fragments")) {
                    fragments += qty;
                    if (shards >= 250 || motes >= 250 || fragments >= 250) {
                        isTrue = true;
                        break;
                    }
                }
            }
            if (isTrue) {
                break;
            }
            input = scanner.nextLine();
        }
        if (shards >= 250) {
            System.out.println("Shadowmourne obtained!");
            int currentShards = materialHashMap.get("shards") - 250;
            materialHashMap.put("shards", currentShards);
        } else if (motes >= 250) {
            System.out.println("Dragonwrath obtained!");
            int currentMotes = materialHashMap.get("motes") - 250;
            materialHashMap.put("motes", currentMotes);
        } else if (fragments >= 250) {
            System.out.println("Valanyr obtained!");
            int currentFragment = materialHashMap.get("fragments") - 250;
            materialHashMap.put("fragments", currentFragment);
        }
        materialHashMap.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        junkHashMap.entrySet().forEach(j -> System.out.printf("%s: %d%n", j.getKey(), j.getValue()));
    }
}
