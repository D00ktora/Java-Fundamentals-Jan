package P04DataTypesAndVariables;

import java.util.Scanner;

public class P09CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int centuries = Integer.parseInt(scanner.nextLine());

        int toYears = centuries * 100;
        double toDays = toYears * 365.2422;
        double toHours = toDays * 24.0;
        double toMinutes = toHours * 60.0;

        System.out.printf("%d centuries = %d years = %.0f days = %.0f hours = %.0f minutes", centuries, toYears, toDays, toHours, toMinutes);
    }
}
