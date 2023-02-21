/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 20.2.2023 г.
 * Time: 19:13
 */
package P30ExamPreparation;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.contains("Done")) {
            if (command.contains("TakeOdd")) {
                String newPassword = generatePassword(password,command);
                password = newPassword;
                System.out.println(password);
            } else if (command.contains("Cut")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int length = Integer.parseInt(command.split(" ")[2]);
                String newPassword =  removeSubString(password,index,length);
                password = newPassword;
                System.out.println(password);
            } else if (command.contains("Substitute")) {
                String substring = command.split(" ")[1];
                String substitute = command.split(" ")[2];
                String newPassword = substituteString(password,substitute,substring);
                if (!newPassword.equals("")) {
                    password = newPassword;
                    System.out.println(password);
                }
            }
            command= scanner.nextLine();
        }
        System.out.printf("Your password is: %s",password);
    }

    private static String substituteString(String password, String substitute, String substring) {
        String newPassword = "";
        if (password.contains(substring)) {
            newPassword = password.replace(substring,substitute);
            return newPassword;
        } else {
            System.out.printf("Nothing to replace!%n");
        }
        return newPassword;
    }

    private static String removeSubString(String password, int index, int length) {
        String substring = password.substring(index, index+length);
        String newPassword = password.replace(substring, "");
        return newPassword;
    }

    private static String generatePassword(String password, String command) {
        String newPass = "";
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                newPass += password.charAt(i);
            }
        }
        return newPass;
    }
}
