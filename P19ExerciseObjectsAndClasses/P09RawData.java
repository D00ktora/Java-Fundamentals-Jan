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

public class P09RawData {
    public static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }
    }
    public static class Cargo {
        int weight;
        String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }
    }
    public static class Tire {
        double tire1Pressure;
        int tire1Age;
        double tire2Pressure;
        int tire2Age;
        double tire3Pressure;
        int tire3Age;
        double tire4Pressure;
        int tire4Age;

        public Tire(double tire1Pressure,
                    int tire1Age,
                    double tire2Pressure,
                    int tire2Age,
                    double tire3Pressure,
                    int tire3Age,
                    double tire4Pressure,
                    int tire4Age) {
            this.tire1Pressure = tire1Pressure;
            this.tire1Age = tire1Age;
            this.tire2Pressure = tire2Pressure;
            this.tire2Age = tire2Age;
            this.tire3Pressure = tire3Pressure;
            this.tire3Age = tire3Age;
            this.tire4Pressure = tire4Pressure;
            this.tire4Age = tire4Age;
        }
    }
    public static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        Tire tire;

        public Car(String model, Engine engine, Cargo cargo, Tire tire) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tire = tire;
        }

        void printCarModel() {
            System.out.println(this.model);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> carsList = new ArrayList<>();
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String inputLine = scanner.nextLine();
            createCar(carsList, inputLine);
        }
        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
                for (Car car : carsList) {
                    if (car.cargo.type.equals("fragile")) {
                        if (car.tire.tire1Pressure < 1 ||
                                car.tire.tire2Pressure < 1 ||
                                car.tire.tire3Pressure < 1 ||
                                car.tire.tire4Pressure < 1) {
                            car.printCarModel();
                        }
                    }
                }
                break;
            case "flamable":
                for (Car car : carsList) {
                    if (car.cargo.type.equals("flamable")) {
                        if (car.engine.power > 250) {
                            car.printCarModel();
                        }
                    }
                }
                break;
        }
    }

    public static void createCar(List<Car> carsList, String inputLine) {
        String[] inputArr = inputLine.split(" ");
        String model = inputArr[0];
        int engineSpeed = Integer.parseInt(inputArr[1]);
        int enginePower = Integer.parseInt(inputArr[2]);
        int cargoWeight = Integer.parseInt(inputArr[3]);
        String cargoType = inputArr[4];
        double tire1Pressure = Double.parseDouble(inputArr[5]);
        int tire1Age = Integer.parseInt(inputArr[6]);
        double tire2Pressure = Double.parseDouble(inputArr[7]);
        int tire2Age = Integer.parseInt(inputArr[8]);
        double tire3Pressure = Double.parseDouble(inputArr[9]);
        int tire3Age = Integer.parseInt(inputArr[10]);
        double tire4Pressure = Double.parseDouble(inputArr[11]);
        int tire4Age = Integer.parseInt(inputArr[12]);

        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age,tire3Pressure,tire3Age,tire4Pressure,tire4Age);
        Car car = new Car(model, engine, cargo, tire);
        carsList.add(car);
    }
}
