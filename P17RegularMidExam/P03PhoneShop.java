/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 19.2.2023 г.
 * Time: 7:11
 */
package P17RegularMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03PhoneShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> phoneList = Arrays.stream(input.split(",\\s+")).map(String::toString).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.contains("End")) {
            if (command.contains("Add ")) {
                String phone = command.split("\\s+-\\s+")[1];
                if (isNotExist(phoneList,phone)){
                    phoneList.add(phone);
                }
            } else if (command.contains("Remove")) {
                String phone = command.split("\\s+-\\s+")[1];
                if (!isNotExist(phoneList, phone)) {
                    phoneList.remove(phone);
                }
            } else if (command.contains("Bonus")) {
                String phone = command.split("\\s+-\\s+")[1];
                String oldPhone = phone.split(":")[0];
                String newPhone = phone.split(":")[1];
                if (!isNotExist(phoneList,oldPhone)) {
                    int index = phoneList.indexOf(oldPhone);
                    if (index < phoneList.size() - 1) {
                        phoneList.add(index + 1, newPhone);
                    } else {
                        phoneList.add(newPhone);
                    }
                }
            } else if (command.contains("Last")) {
                String phone = command.split("\\s+-\\s+")[1];
                if (!isNotExist(phoneList,phone)) {
                    phoneList.remove(phone);
                    phoneList.add(phone);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", phoneList));
    }

    private static boolean isNotExist(List<String> phoneList, String phone) {
        for (String prone : phoneList) {
            if (prone.equals(phone)) {
                return false;
            }
        }
        return true;
    }
}
