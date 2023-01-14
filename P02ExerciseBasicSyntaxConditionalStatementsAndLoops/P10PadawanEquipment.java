package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double georgMoney = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceLightsabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double numberOfLightsabers = Math.ceil(students * 1.1);

        int numberOfBelts = students / 6;
        numberOfBelts = students - numberOfBelts;

        double moneyForLightsabers = numberOfLightsabers * priceLightsabers;
        double moneyForRobes = students * priceRobes;
        double moneyForBelts = numberOfBelts * priceBelts;

        double totalSum = moneyForBelts + moneyForLightsabers + moneyForRobes;

        if (georgMoney >= totalSum) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            totalSum -= georgMoney;
            System.out.printf("George Lucas will need %.2flv more.", totalSum);
        }
    }
}
