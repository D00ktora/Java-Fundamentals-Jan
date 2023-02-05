/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.2.2023 г.
 * Time: 5:44
 */
package P19ExerciseObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P10CarSalesman {

    public static class Car {
        String model;
        Engine engine;
        String weight = "n/a";
        String color = "n/a";

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
        }

        public Car(String model, Engine engine, String weight) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
        }

        public Car(String model, Engine engine, String weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }
    }
    public static class Engine {
        String model;
        String power;
        String displacement = "n/a";
        String efficiency = "n/a";

        public Engine(String model, String power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public Engine(String model, String power) {
            this.model = model;
            this.power = power;
        }

        public Engine(String model, String power, String displacement) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfEngines; i++) {
            String inputLine = scanner.nextLine();
            String[] inputArr = inputLine.split(" ");
            String model = inputArr[0];
            String power = inputArr[1];
            String displacement = "n/a";
            String efficiency = "n/a";
            if (inputArr.length == 3) {
                if (inputArr[2].charAt(0) >= '0' && inputArr[2].charAt(0) <= '9') {
                    displacement = inputArr[2];
                } else {
                    efficiency = inputArr[2];
                }
            } else if (inputArr.length == 4) {
                displacement = inputArr[2];
                efficiency = inputArr[3];
            }
            Engine engine = new Engine(model,power,displacement,efficiency);
            engineList.add(engine);
        }

        int numbeOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numbeOfCars; i++) {
            String inputLine = scanner.nextLine();
            String[] inputArr = inputLine.split(" ");
            String model = inputArr[0];
            String engineString = inputArr[1];
            Engine engine = null;
            String weight = "n/a";
            String color = "n/a";
            if (inputArr.length == 3) {
                if (inputArr[2].charAt(0) >= '0' && inputArr[2].charAt(0) <= '9') {
                    weight = inputArr[2];
                } else {
                    color = inputArr[2];
                }
            } else if (inputArr.length == 4) {
                weight = inputArr[2];
                color = inputArr[3];
            }

            for (Engine engine1 : engineList) {
                if (engine1.model.equals(engineString)) {
                    engine = engine1;
                    break;
                }
            }

            Car car = new Car(model, engine, weight, color);
            carList.add(car);
        }

        for (Car car : carList) {
            System.out.printf("%s:%n",car.model);
            System.out.printf("  %s:%n",car.engine.model);
            System.out.printf("    Power: %s%n",car.engine.power);
            System.out.printf("    Displacement: %s%n",car.engine.displacement);
            System.out.printf("    Efficiency: %s%n",car.engine.efficiency);
            System.out.printf("  Weight: %s%n",car.weight);
            System.out.printf("  Color: %s%n", car.color);
        }
    }
}
