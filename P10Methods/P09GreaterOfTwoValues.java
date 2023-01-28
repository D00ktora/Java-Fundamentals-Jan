package P10Methods;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String value1 = scanner.nextLine();
        String value2 = scanner.nextLine();

        String result = getMax(type,value1,value2);
        System.out.println(result);
    }

    private static String getMax(String type, String value1, String value2) {
        String result = "";

        switch (type){
            case "int":
                int tempVal1 = Integer.parseInt(String.valueOf(value1));
                int tempVal2 = Integer.parseInt(String.valueOf(value2));

                if (tempVal1 > tempVal2) {
                    result = String.valueOf(value1);
                    return result;
                } else {
                    result = String.valueOf(value2);
                    return result;
                }
            case "char":
                char tempChar1 = value1.charAt(0);
                char tempChar2 = value2.charAt(0);

                if (tempChar1 > tempChar2) {
                    result += tempChar1;
                    return result;
                } else {
                    result += tempChar2;
                    return result;
                }
            case "string":
                if (value1.compareTo(value2) > 0) {
                    return value1;
                } else {
                    return value2;
                }
        }
        return null;
    }
}
