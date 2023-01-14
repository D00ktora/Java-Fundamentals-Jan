package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P16Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String result = "";

        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            int times = input.length();
            int digit = Integer.parseInt(String.valueOf(input.charAt(0)));

            switch (digit){
                case 2:
                    if (times == 1) {
                        result += 'a';
                    } else if (times == 2) {
                        result += 'b';
                    } else if (times == 3) {
                        result += 'c';
                    }
                    break;
                case 3:
                    if (times == 1) {
                        result += 'd';
                    } else if (times == 2) {
                        result += 'e';
                    } else if (times == 3) {
                        result += 'f';
                    }
                    break;
                case 4:
                    if (times == 1) {
                        result += 'g';
                    } else if (times == 2) {
                        result += 'h';
                    } else if (times == 3) {
                        result += 'i';
                    }
                    break;
                case 5:
                    if (times == 1) {
                        result += 'j';
                    } else if (times == 2) {
                        result += 'k';
                    } else if (times == 3) {
                        result += 'l';
                    }
                    break;
                case 6:
                    if (times == 1) {
                        result += 'm';
                    } else if (times == 2) {
                        result += 'n';
                    } else if (times == 3) {
                        result += 'o';
                    }
                    break;
                case 7:
                    if (times == 1) {
                        result += 'p';
                    } else if (times == 2) {
                        result += 'q';
                    } else if (times == 3) {
                        result += 'r';
                    } else if (times == 4) {
                        result += 's';
                    }
                    break;
                case 8:
                    if (times == 1) {
                        result += 't';
                    } else if (times == 2) {
                        result += 'u';
                    } else if (times == 3) {
                        result += 'v';
                    }
                    break;
                case 9:
                    if (times == 1) {
                        result += 'w';
                    } else if (times == 2) {
                        result += 'x';
                    } else if (times == 3) {
                        result += 'y';
                    } else if (times == 4) {
                        result += 'z';
                    }
                    break;
                case 0:
                    result += ' ';
                    break;
            }
        }

        System.out.println(result);
    }
}
