/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 21:30
 */
package P16ExamPreparation2;

import org.w3c.dom.CDATASection;

import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        AtomicInteger shipMaxHealth = new AtomicInteger(Integer.parseInt(scanner.nextLine()));
        String commands = scanner.nextLine();
        AtomicBoolean pirateWon = new AtomicBoolean(false);
        AtomicBoolean warShipWon = new AtomicBoolean(false);
        int pirateShipIndex = 1;
        int warShipIndex = 2;
        while (!commands.contains("Retire")) {
            if (commands.contains("Fire")) {
                int index = Integer.parseInt(commands.split(" ")[1]);
                int damage = Integer.parseInt(commands.split(" ")[2]);
                if (isValidIndex(warShip,index)) {
                    shipAttack(warShip, index, damage, pirateWon,pirateShipIndex);
                    if (pirateWon.get()) {
                        return;
                    }
                }
            } else if (commands.contains("Defend")) {
                int startIndex = Integer.parseInt(commands.split(" ")[1]);
                int endIndex = Integer.parseInt(commands.split(" ")[2]);
                int damage = Integer.parseInt(commands.split(" ")[3]);
                if (isValidIndex(pirateShip, startIndex) && isValidIndex(pirateShip,endIndex)){
                    for (int i = startIndex; i <= endIndex; i++) {
                        shipAttack(pirateShip,i,damage,warShipWon,warShipIndex);
                        if (warShipWon.get()){
                            return;
                        }
                    }
                }
            } else if (commands.contains("Repair")) {
                int index = Integer.parseInt(commands.split(" ")[1]);
                int health = Integer.parseInt(commands.split(" ")[2]);
                if (isValidIndex(pirateShip, index)) {
                    repair(pirateShip, index, health, shipMaxHealth);
                }
            } else if (commands.contains("Status")) {
                count(pirateShip, shipMaxHealth);
            }
            commands = scanner.nextLine();
        }
        int pirateShipSum = 0;
        int warShipSum = 0;
        for (int i = 0; i < pirateShip.size(); i++) {
            pirateShipSum += pirateShip.get(i);
        }
        for (int i = 0; i < warShip.size(); i++) {
            warShipSum += warShip.get(i);
        }
        System.out.printf("Pirate ship status: %d%n",pirateShipSum);
        System.out.printf("Warship status: %d%n",warShipSum);
    }

    private static void count(List<Integer> pirateShip, AtomicInteger maxhealth) {
        double temp = 0.0;
        int count = 0;
        for (int i = 0; i < pirateShip.size(); i++) {
            if (pirateShip.get(i) < maxhealth.get() * 0.2) {
                count++;
            }
        }
        System.out.printf("%d sections need repair.%n", count);
    }

    private static void repair(List<Integer> pirateShip, int index, int health, AtomicInteger shipMaxHealth) {
        if (pirateShip.get(index) + health <= shipMaxHealth.get()){
            pirateShip.set(index, pirateShip.get(index) + health);
        } else if (pirateShip.get(index) + health > shipMaxHealth.get()) {
            pirateShip.set(index, shipMaxHealth.get());
        }
    }

    private static void shipAttack(List<Integer> warShip, int index, int damage, AtomicBoolean pirateWon, int shipIndex) {
        warShip.set(index, warShip.get(index) - damage);
        if (warShip.get(index) <= 0) {
            if (shipIndex == 1) {
                System.out.println("You won! The enemy ship has sunken.");
            } else if (shipIndex == 2) {
                System.out.println("You lost! The pirate ship has sunken.");
            }
            pirateWon.set(true);
        }
    }

    static boolean isValidIndex(List<Integer> ship, int index) {
        if (index < 0){
            return false;
        }
        if (index >= ship.size()) {
            return false;
        }
        return true;
    }
}
