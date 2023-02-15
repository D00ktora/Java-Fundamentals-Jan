/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 15.2.2023 г.
 * Time: 17:19
 */
package P25ExerciseTextProcessing;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P12MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> codes = Arrays.stream(scanner.nextLine().split("\\s+")).map(String::toString).collect(Collectors.toList());
        String result = "";
        for (String code : codes) {
            switch (code) {
                case ".-":
                    result += "A";
                    break;
                case "-...":
                    result += "B";
                    break;
                case "-.-.":
                    result += "C";
                    break;
                case "-..":
                    result += "D";
                    break;
                case ".":
                    result += "E";
                    break;
                case "..-.":
                    result += "F";
                    break;
                case "--.":
                    result += "G";
                    break;
                case "....":
                    result += "H";
                    break;
                case "..":
                    result += "I";
                    break;
                case ".---":
                    result += "J";
                    break;
                case "-.-":
                    result += "K";
                    break;
                case ".-..":
                    result += "L";
                    break;
                case "--":
                    result += "M";
                    break;
                case "-.":
                    result += "N";
                    break;
                case "---":
                    result += "O";
                    break;
                case ".--.":
                    result += "P";
                    break;
                case "--.-":
                    result += "Q";
                    break;
                case ".-.":
                    result += "R";
                    break;
                case "...":
                    result += "S";
                    break;
                case "-":
                    result += "T";
                    break;
                case "..-":
                    result += "U";
                    break;
                case "...-":
                    result += "V";
                    break;
                case ".--":
                    result += "W";
                    break;
                case "-..-":
                    result += "X";
                    break;
                case "-.--":
                    result += "Y";
                    break;
                case "--..":
                    result += "Z";
                    break;
                case "|":
                    result += " ";
            }
        }
        System.out.println(result);
    }
}
