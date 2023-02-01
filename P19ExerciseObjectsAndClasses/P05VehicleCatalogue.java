/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.2.2023 г.
 * Time: 5:43
 */
package P19ExerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Scanner;

public class P05VehicleCatalogue {

    public static class Viacle {
        String type;
        String model;
        String color;
        int horsepower;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public void setHorsepower(int horsepower) {
            this.horsepower = horsepower;
        }

        public Viacle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        void printViacle() {
            if (this.type.equals("car")) {
                this.type = "Car";
            } else if (this.type.equals("truck")) {
                this.type = "Truck";
            }
            System.out.printf("Type: %s%n",this.type);
            System.out.printf("Model: %s%n",this.model);
            System.out.printf("Color: %s%n",this.color);
            System.out.printf("Horsepower: %d%n",this.horsepower);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Viacle> viacleList = new ArrayList<>();
        String command = scanner.nextLine();
        int numberOfCars = 0;
        int numberOfTrucks = 0;
        int totalHorsepowerCars = 0;
        int totalHorsepowerTrucks = 0;
        while (!command.contains("End")) {
            String type = command.split(" ")[0];
            String model = command.split(" ")[1];
            String color = command.split(" ")[2];
            int horspower = Integer.parseInt(command.split(" ")[3]);
            Viacle tempViacle = new Viacle(type,model,color,horspower);
            viacleList.add(tempViacle);
            if (type.equals("truck")) {
                numberOfTrucks++;
                totalHorsepowerTrucks += horspower;
            } else if (type.equals("car")) {
                numberOfCars++;
                totalHorsepowerCars += horspower;
            }
            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.contains("Close the Catalogue")) {
            String model = command.split(" ")[0];
            for (int i = 0; i < viacleList.size(); i++) {
                if (viacleList.get(i).model.equals(model)) {
                    viacleList.get(i).printViacle();
                }
            }
            command = scanner.nextLine();
        }
        double hpCar = 0;
        if (numberOfCars != 0) {
            hpCar = totalHorsepowerCars * 1.0 / numberOfCars;
        }else hpCar = 0;
        double hpTruck = 0;
        if (numberOfTrucks != 0) {
            hpTruck = totalHorsepowerTrucks * 1.0 / numberOfTrucks;
        }else hpTruck = 0;

        System.out.printf("Cars have average horsepower of: %.2f.\n",hpCar);
        System.out.printf("Trucks have average horsepower of: %.2f.\n", hpTruck);
    }
}
