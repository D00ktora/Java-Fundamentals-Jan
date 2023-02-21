/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 16.2.2023 г.
 * Time: 18:14
 */
package P28ExerciseRegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02Race {
    public static class Racer {
        String name;
        int distance = 0;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Racer(String name, int distance) {
            this.name = name;
            this.distance += distance;
        }

        public Racer(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Racer> racersList = new ArrayList<>();
        String[] racersArr = scanner.nextLine().split(",\\s+");
        for (String racer : racersArr) {
            Racer player = new Racer(racer);
            racersList.add(player);
        }

        String input = scanner.nextLine();

        while (!input.contains("end of race")) {
            String regexName = "(?<name>[A-Za-z]+)";
            Pattern pattern = Pattern.compile(regexName);
            Matcher matcher = pattern.matcher(input);
            List<String> TempName = new ArrayList<>();
            while (matcher.find()) {
                String letter = matcher.group("name");
                TempName.add(letter);
            }
            String name = "";
            for (String s : TempName) {
                name += s;
            }
            regexName = "(?<numbers>[0-9])";
            pattern = Pattern.compile(regexName);
            matcher = pattern.matcher(input);
            int sum = 0;
            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group("numbers"));
                sum += number;
            }

            for (Racer racer : racersList) {
                if (racer.getName().equals(name)) {
                    racer.setDistance(racer.getDistance() + sum);
                    break;
                }
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < racersList.size() - 1; i++) {
            if (racersList.get(i).getDistance() < racersList.get(i+1).getDistance()) {
                Racer temp = racersList.get(i);
                racersList.set(i, racersList.get(i+1));
                racersList.set(i+1, temp);
                i = -1;
            }
        }


        if (racersList.size() >= 1) {
            System.out.printf("1st place: %s%n", racersList.get(0).getName());
        }
        if (racersList.size() >= 2) {
            System.out.printf("2nd place: %s%n", racersList.get(1).getName());
        }
        if (racersList.size() >= 3) {
            System.out.printf("3rd place: %s%n", racersList.get(2).getName());
        }
    }
}
