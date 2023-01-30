/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 18:36
 */
package P16ExamPreparation2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AtomicInteger health = new AtomicInteger(100);
        AtomicInteger bitcoin = new AtomicInteger(0);
        List<String> rooms = Arrays.stream(scanner.nextLine().split("[|]")).collect(Collectors.toList());
        AtomicBoolean death = new AtomicBoolean(false);
        for (int i = 0; i < rooms.size(); i++) {
            String command = rooms.get(i).split(" ")[0];
            int value = Integer.parseInt(rooms.get(i).split(" ")[1]);
            if (command.contains("potion")){
                heal(health,value);
            } else if (command.contains("chest")) {
                chest(bitcoin, value);
            }else {
                attack(health,value, command, death, i);
            }

            if (death.get()) {
                return;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n",bitcoin.get());
        System.out.printf("Health: %d%n",health.get());
    }

    private static void attack(AtomicInteger health, int value, String monster, AtomicBoolean death, int index) {
        if (health.get() - value > 0) {
            health.set(health.get() - value);
            System.out.printf("You slayed %s.%n",monster);
        } else if (health.get() - value <= 0) {
            death.set(true);
            System.out.printf("You died! Killed by %s.%n",monster);
            System.out.printf("Best room: %d%n",index+1);
        }
    }

    private static void chest(AtomicInteger bitcoin, int value) {
        bitcoin.set(bitcoin.get() + value);
        System.out.printf("You found %d bitcoins.%n",value);
    }

    private static void heal(AtomicInteger health, int value) {
        if (health.get() + value <= 100) {
            health.set(health.get() + value);
            System.out.printf("You healed for %d hp.%n",value);
            System.out.printf("Current health: %d hp.%n",health.get());
        } else {
            int neededToBeFull = 100 - health.get();
            health.set(100);
            System.out.printf("You healed for %d hp.%n",neededToBeFull);
            System.out.printf("Current health: %d hp.%n",health.get());
        }
    }
}
