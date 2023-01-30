/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.1.2023 г.
 * Time: 8:39
 */
package P16ExamPreparation2;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double food = Double.parseDouble(scanner.nextLine()) * 1000.0;
        double hay = Double.parseDouble(scanner.nextLine()) * 1000.0;
        double cover = Double.parseDouble(scanner.nextLine()) * 1000.0;
        double pigKG = Double.parseDouble(scanner.nextLine()) * 1000.0;


        for (int i = 1; i <= 30; i++) {
            //feed pet
            food -= 300;
            //check if its second day
            if (i % 2 == 0) {
                //give hay
                double amountOfHay = food * 0.05;
                hay -= amountOfHay;
            }
            //check if its thurd day
            if (i % 3 == 0) {
                //put cover
                double amountOfCover = pigKG / 3.0;
                cover -= amountOfCover;
            }
            //check supplys
            if (food <= 0 || hay <= 0 || cover <= 0) {
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }
        food /= 1000;
        hay /= 1000;
        cover /= 1000;
        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",food,hay,cover);
    }
}
