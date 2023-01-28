package P14ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. Получаваме две ръце от карти (масив от цели числа)
        //2. Започваме от началото на двете тестета.
        //3. Сравняваме картата от първото с тази от второто тесте.
        //4. Играча с по-голяма карта взима и двете карти и си ги добавя в края на тестето.
        //5. Като при добавяне, добавяме първо печелившата карта а след това картата на противника.
        //6. Премахваме картата, която сме взели от по-слабия играч от тестето му.
        //7. Ако стойностите на картите са равни, никой не печели и трябва да бъдат премахнати и двете карти от двете тестета.
        //8. Играта приключва, когато едно от двете тестета остане празно.
        //9. Събираме сумата на печелившото тесте, от всички карти.
        //10. Принтираме на конзолата: "{First/Second} player wins! Sum: {sum}"

/*Вход
20 30 40 50
10 20 30 40
 */

/*
10 20 30 40 50
50 40 30 30 10
 */


        List<Integer> player1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> player2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (player1.size() > 0 && player2.size() > 0) {
            int player1Card = player1.get(0);
            int player2Card = player2.get(0);

            if (player1Card > player2Card) {
                player1.add(player1Card);
                player1.add(player2Card);
                player1.remove(0);
                player2.remove(0);
            } else if (player2Card > player1Card) {
                player2.add(player2Card);
                player2.add(player1Card);
                player2.remove(0);
                player1.remove(0);
            } else if (player1Card == player2Card) {
                player1.remove(0);
                player2.remove(0);
            }
        }

        int sum = 0;
        String player = "";
        if (player2.size() > 0) {
            for (Integer integer : player2) {
                sum += integer;
            }
            player = "Second";
        } else if (player1.size() > 0) {
            for (Integer integer : player1) {
                sum += integer;
            }
            player = "First";
        }

        System.out.printf("%s player wins! Sum: %d",player, sum);
    }
}
