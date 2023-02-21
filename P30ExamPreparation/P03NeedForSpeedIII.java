/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 20.2.2023 г.
 * Time: 6:32
 */
package P30ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03NeedForSpeedIII {
    public static class Car {
        String model;
        int mileage;
        int fuel;

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public Car(String model, int mileage, int fuel) {
            this.model = model;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public void printCar() {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",this.model, this.mileage, this.fuel);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String inputCar = scanner.nextLine();
            String name = inputCar.split("[|]")[0];
            int mileage = Integer.parseInt(inputCar.split("[|]")[1]);
            int fuel = Integer.parseInt(inputCar.split("[|]")[2]);
            Car newCar = new Car(name,mileage,fuel);
            carList.add(newCar);
        }
        String commands = scanner.nextLine();

        while (!commands.contains("Stop")) {
            if (commands.contains("Drive")) {
                String name = commands.split(" : ")[1];
                int mileage = Integer.parseInt(commands.split(" : ")[2]);
                int neededFuel = Integer.parseInt(commands.split(" : ")[3]);
                if (carHaveEnoughFuel(name,mileage,neededFuel,carList)) {
                    increaseMileage(carList,neededFuel,mileage,name);
                } else {
                    System.out.println("Not enough fuel to make that ride");
                }
            } else if (commands.contains("Refuel")) {
                String name = commands.split(" : ")[1];
                int fuelToRefill = Integer.parseInt(commands.split(" : ")[2]);
                fillCar(carList,name,fuelToRefill);
            } else if (commands.contains("Revert")) {
                String name = commands.split(" : ")[1];
                int mileage = Integer.parseInt(commands.split(" : ")[2]);
                revertMileage(carList,name,mileage);
            }
            commands = scanner.nextLine();
        }

        for (Car car : carList) {
            car.printCar();
        }
    }

    private static void revertMileage(List<Car> carList, String name, int mileage) {
        for (Car car : carList) {
            if (car.getModel().equals(name)) {
                if (car.getMileage() - mileage >= 10000) {
                    car.setMileage(car.getMileage() - mileage);
                    System.out.printf("%s mileage decreased by %d kilometers%n",name,mileage);
                    break;
                } else {
                    car.setMileage(10000);
                    break;
                }
            }
        }
    }

    private static void fillCar(List<Car> carList, String name, int fuelToRefill) {
        for (Car car : carList) {
            if (car.getModel().equals(name)) {
                if (car.getFuel() + fuelToRefill <= 75) {
                    car.setFuel(car.getFuel() + fuelToRefill);
                    System.out.printf("%s refueled with %d liters%n",name,fuelToRefill);
                    break;
                } else {
                    int neededFule = 75 - car.getFuel();
                    car.setFuel(75);
                    System.out.printf("%s refueled with %d liters%n",name,neededFule);
                    break;
                }
            }
        }
    }

    private static void increaseMileage(List<Car> carList, int neededFuel, int mileage, String name) {
        for (Car car : carList) {
            if (car.getModel().equals(name)) {
                car.setFuel(car.getFuel() - neededFuel);
                car.setMileage(car.getMileage() + mileage);
                System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",name,mileage,neededFuel);
                if (car.getMileage() >= 100000) {
                    carList.remove(car);
                    System.out.printf("Time to sell the %s!%n",name);
                }
                break;
            }
        }
    }

    private static boolean carHaveEnoughFuel(String name, int mileage, int neededFuel, List<Car> carList) {
        for (Car car : carList) {
            if (car.getModel().equals(name)) {
                if (car.getFuel() >= neededFuel) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
