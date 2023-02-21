/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 20.2.2023 г.
 * Time: 19:45
 */
package P30ExamPreparation;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class P03Pirates {
    public static class City {
        String name;
        int population;
        int gold;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public void increasePopulationAndGold(int population, int gold) {
            this.population = this.population + population;
            this.gold = this.gold + gold;
        }

        public void plunder(int people, int gold) {
            int killedPpl;
            int stolenGold;
            if (this.population - people < 0) {
                killedPpl = people - this.population;
                this.population = 0;
            } else {
                killedPpl = people;
                this.population = this.population - people;
            }
            if (this.gold - gold < 0) {
                stolenGold = gold - this.gold;
                this.gold = 0;
            } else {
                stolenGold = gold;
                this.gold = this.gold - gold;
            }
            System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",this.name, stolenGold, killedPpl);
        }

        public void prosper(int gold) {
            if (gold < 0) {
                System.out.println("Gold added cannot be a negative number!");
            } else {
                this.gold = this.gold + gold;
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",gold, this.name, this.gold);
            }
        }

        public void printCity() {
            System.out.println(this.name + " -> Population: " + this.population + " citizens, Gold: " + this.gold + " kg");
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cityInput = scanner.nextLine();
        List<City> cityList = new ArrayList<>();
        while (!cityInput.contains("Sail")) {
            String name = cityInput.split("\\|\\|")[0];
            int population = Integer.parseInt(cityInput.split("\\|\\|")[1]);
            int gold = Integer.parseInt(cityInput.split("\\|\\|")[2]);
            boolean cityIsCreated = false;
            for (City city : cityList) {
                if (city.name.equals(name)) {
                    city.increasePopulationAndGold(population,gold);
                    cityIsCreated = true;
                    break;
                }
            }
            if (!cityIsCreated) {
                City newCity = new City(name, population, gold);
                cityList.add(newCity);
            }
            cityInput = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!command.contains("End")) {
            if (command.contains("Plunder")) {
                String name = command.split("=>")[1];
                int population = Integer.parseInt(command.split("=>")[2]);
                int gold = Integer.parseInt(command.split("=>")[3]);
                for (City city : cityList) {
                    if (city.getName().equals(name)){
                        city.plunder(population,gold);
                        if (city.getGold() <= 0 || city.getPopulation() <= 0) {
                            cityList.remove(city);
                            System.out.printf("%s has been wiped off the map!%n",name);
                            break;
                        }
                        break;
                    }
                }
            } else if (command.contains("Prosper")) {
                String name = command.split("=>")[1];
                int gold = Integer.parseInt(command.split("=>")[2]);
                for (City city : cityList) {
                    if (city.getName().equals(name)) {
                        city.prosper(gold);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        if (cityList.size() > 0 ) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cityList.size());
            for (City city : cityList) {
                city.printCity();
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
