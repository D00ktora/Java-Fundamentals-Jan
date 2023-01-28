package P07Arrays;

import java.sql.Array;
import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrString = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int input = Integer.parseInt(scanner.nextLine());

        switch (input) {
            case 1:
                System.out.println(arrString[0]);
                break;
            case 2:
                System.out.println(arrString[1]);
                break;
            case 3:
                System.out.println(arrString[2]);
                break;
            case 4:
                System.out.println(arrString[3]);
                break;
            case 5:
                System.out.println(arrString[4]);
                break;
            case 6:
                System.out.println(arrString[5]);
                break;
            case 7:
                System.out.println(arrString[6]);
                break;
            default:
                System.out.println("Invalid day!");
                break;
        }
    }
}
