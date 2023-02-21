/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 20.2.2023 г.
 * Time: 19:43
 */
package P30ExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^@#+(?=[A-Z])([A-Za-z0-9]{6,})(?<=[A-Z])@#+$";
        int nums = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile(regex);

        while (nums > 0) {
            String input = scanner.nextLine();
            String[] pass = input.split(", ");

            for (int i = 0; i < pass.length; i++) {
                String current = pass[i];
                Matcher matcher = pattern.matcher(current);
                if (matcher.find()) {
                    String todo = current;

                    String numbers="";
                    for(char c: todo.toCharArray()){
                        if (Character.isDigit(c)) {
                            numbers=numbers+c;
                        }
                    }
                    if(numbers.isEmpty()){
                        System.out.println("Product group: 00");
                    }else {
                        System.out.println("Product group: " + numbers);
                    }
                } else if (!matcher.find()){
                    System.out.println("Invalid barcode");
                }
            }
            nums--;
        }
    }
}
