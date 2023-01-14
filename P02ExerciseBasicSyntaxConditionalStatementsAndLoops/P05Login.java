package P02ExerciseBasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String password = "";

        for (int i = userName.length() - 1; i >= 0; i--) {
            password += userName.charAt(i);
        }

        String input = scanner.nextLine();
        Boolean blocked = false;
        int counter = 0;
        while (!input.equals(password)){
            counter++;
            if (counter == 4){
                blocked = true;
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }
        if (blocked){
            System.out.printf("User %s blocked!%n",userName);
        }else {
            System.out.printf("User %s logged in.%n",userName);
        }
    }
}
