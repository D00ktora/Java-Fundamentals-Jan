/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 13.2.2023 г.
 * Time: 4:59
 */
package P25ExerciseTextProcessing;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitString = input.split("\\\\");
        String file = "";
        for (String s : splitString) {
            if (s.contains(".")) {
                file = s;
                break;
            }
        }
        String name = file.split("[.]")[0];
        String extention = file.split("[.]")[1];
        System.out.printf("File name: %s%n",name);
        System.out.printf("File extension: %s%n",extention);
    }
}
