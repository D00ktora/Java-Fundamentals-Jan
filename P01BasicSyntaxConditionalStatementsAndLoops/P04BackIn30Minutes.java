package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        //calculate the minutes
        int inputMin = hours * 60 + minutes;
        int minutesPlus30Min = inputMin + 30;

        //calculate hour after 30 min
        int hour = minutesPlus30Min / 60;
        int minutesToRemove = hour * 60;

        if (hour > 23){
            hour -= 24;
        }

        //calculate rest minutes
        int minute = minutesPlus30Min - minutesToRemove;

        //print
        System.out.printf("%d:%02d",hour,minute);
    }
}
