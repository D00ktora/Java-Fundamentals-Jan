/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.2.2023 г.
 * Time: 17:10
 */
package P30ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03PlantDiscovery {

    public static class Plant {
        String name;
        int rarity;
        List<Double> rating = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Double> getRating() {
            return rating;
        }

        public void setRating(List<Double> rating) {
            this.rating = rating;
        }

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
        }

        public void printPlant() {
            double average = 0;
            double sum = 0;
            for (Double aDouble : rating) {
                sum += aDouble;
            }
            average = sum / rating.size();
            if (rating.isEmpty()) {
                average = 0;
            }
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",name,rarity,average);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        List<Plant> plantList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            String name = input.split("<->")[0];
            int rarity = Integer.parseInt(input.split("<->")[1]);
            if (isPlantExist(plantList, name)){
                updatePlantRarity(plantList,rarity,name);
            } else {
                Plant newPlant = new Plant(name, rarity);
                plantList.add(newPlant);
            }
        }
        String commands = scanner.nextLine();

        while (!commands.contains("Exhibition")) {
            if (commands.contains("Rate")) {
                String command = commands.split(": ")[1];
                String name = command.split(" - ")[0];
                double rate = Double.parseDouble(command.split(" - ")[1]);
                if (isPlantExist(plantList,name)) {
                    for (Plant plant : plantList) {
                        if (plant.getName().equals(name)) {
                            List<Double> newRating = plant.getRating();
                            newRating.add(rate);
                            plant.setRating(newRating);
                            break;
                        }
                    }
                } else {
                    System.out.println("error");
                }
            } else if (commands.contains("Update")) {
                String command = commands.split(": ")[1];
                String name = command.split(" - ")[0];
                int rarity = Integer.parseInt(command.split(" - ")[1]);
                if (isPlantExist(plantList,name)){
                    for (Plant plant : plantList) {
                        if (plant.getName().equals(name)){
                            plant.setRarity(rarity);
                        }
                    }
                } else {
                    System.out.println("error");
                }
            } else if (commands.contains("Reset")) {
                String name = commands.split(": ")[1];
                if (isPlantExist(plantList,name)) {
                    for (Plant plant : plantList) {
                        if (plant.getName().equals(name)){
                            List<Double> newList = new ArrayList<>();
                            plant.setRating(newList);
                            break;
                        }
                    }
                } else {
                    System.out.println("error");
                }
            }
            commands = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Plant plant : plantList) {
            plant.printPlant();
        }
    }

    private static void updatePlantRarity(List<Plant> plantList, int rarity, String name) {
        for (Plant plant : plantList) {
            if (plant.getName().equals(name)) {
                plant.setRarity(rarity);
                break;
            }
        }
    }

    private static boolean isPlantExist(List<Plant> plantList, String name) {
        for (Plant plant : plantList) {
            if (plant.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
