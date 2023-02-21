/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 17.2.2023 г.
 * Time: 17:41
 */
package P28ExerciseRegularExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //трябва да се изброят всички букви [s,t, a, r], без значение дали са големи
        //след това трябва да се пребахне броя на всеки симвул от числовата му стойност в ASCII таблицата
        //след декриптиране
            //всеко съобщение трябва да има : име на планетата, население, тип на атаката (А за атака и Д за унищожение) и брой войници.
            //Името на планетата ще започва с @ и ще съдържа само букви
            //Населението започва след ":" и ще е цяло число.
            //Броя на войниците започва след "->" и ще е цяло число.
            //Съобщението ще е във вида : име на планетата -> население -> тип на атаката -> брой на войниците
                //Всички думи могат да бъдат разделени с всякакъв символ освен ['@', '-', '!', ':', '>']

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (int i = 0; i < numberOfMessages; i++) {
            int numberOfLetters = 0;
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("[SsTtAaRr]");
            Matcher matcher = pattern.matcher(input);
            String decryptedMassage = "";
            boolean missingData = false;
            // намираме колко броя от буквите се срещат
            while (matcher.find()) {
                numberOfLetters ++;
            }
            //декриптиране на съобщението
            decryptedMassage = decryptMassage(input,numberOfLetters);
            //вземаме името на планетата
            pattern = Pattern.compile("@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>\\d+)[^@\\-!:>]*!(?<attackType>A|D)![^@\\-!:>]*->(?<soldierCount>\\d+)");
            matcher = pattern.matcher(decryptedMassage);
            String nameOfThePlanet = "";
            int populationOfThePlanet = 0;
            String attackType = "";
            int numberOfSolgers = 0;

            if (matcher.find()) {
                nameOfThePlanet = matcher.group("planetName");
                populationOfThePlanet = Integer.parseInt(matcher.group("population"));
                attackType = matcher.group("attackType");
                numberOfSolgers = Integer.parseInt(matcher.group("soldierCount"));
            } else {

            }

            if (!missingData) {
                if (attackType.equals("A")) {
                    attackedPlanets.add(nameOfThePlanet);
                } else if (attackType.equals("D")) {
                    destroyedPlanets.add(nameOfThePlanet);
                }
            }
        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.printf("Attacked planets: %d%n",attackedPlanets.size());
        for (String attackedPlanet : attackedPlanets) {
            System.out.printf("-> %s%n",attackedPlanet);
        }
        System.out.printf("Destroyed planets: %d%n",destroyedPlanets.size());
        for (String destroyedPlanet : destroyedPlanets) {
            System.out.printf("-> %s%n",destroyedPlanet);
        }

    }

    private static String decryptMassage(String input, int numberOfLetters) {
        StringBuilder builder = new StringBuilder(input);

        for (int i = 0; i < builder.length(); i++) {
            char old = builder.charAt(i);
            char newChar = (char) (old - numberOfLetters);
            String newString = String.valueOf(newChar);
            builder.replace(i,i+1,newString);
        }
        return builder.toString();
    }
}
