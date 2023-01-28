package P14ExerciseList;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class P08AnonymousThreatNotIncludedInFinalScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//    1.  Входа е стринг разделен със спейсове
//    2.  Стринга може да съдържа всички символи без празни места
        List<String> strings = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String[] commands = scanner.nextLine().split(" ");
        String startIndex = "";
        String endIndex = "";
        String index = "";
        String partitions = "";
        String command = commands[0];
//        if (command.equals("merge")) {
//            startIndex = commands[1];
//            endIndex = commands[2];
//            if (Integer.parseInt(String.valueOf(startIndex)) < 0) {
//                startIndex = "0";
//            }
//            if (Integer.parseInt(String.valueOf(endIndex)) > strings.size()) {
//                endIndex = String.valueOf(strings.size());
//            }
//        } else if (command.equals("divide")) {
//            index = commands[1];
//            partitions = commands[2];
//        }

        while (!command.equals("3:1")) {
            if (command.equals("merge")) {
                startIndex = commands[1];
                endIndex = commands[2];
                if (Integer.parseInt(String.valueOf(startIndex)) < 0) {
                    if (Integer.parseInt(String.valueOf(startIndex)) > strings.size()-1) {
                        startIndex = String.valueOf(strings.size()-1);
                    }//1212123213213213123132123132132132123123123
                    startIndex = "0";
                }
                if (Integer.parseInt(String.valueOf(endIndex)) > strings.size() - 1) {
                    endIndex = String.valueOf(strings.size() - 1);
                }
            } else if (command.equals("divide")) {
                index = commands[1];
                partitions = commands[2];
            }

            if (command.equals("merge")) {
                String temp = "";
                for (int i = Integer.parseInt(String.valueOf(startIndex)); i <= Integer.parseInt(String.valueOf(endIndex)); i++) {
                    temp += strings.get(i);
//                    strings.remove(i);
                }
                for (int i = Integer.parseInt(String.valueOf(startIndex)); i <= Integer.parseInt(String.valueOf(endIndex)); i++) {
                    strings.remove(Integer.parseInt(String.valueOf(startIndex)));
                }
                if (!temp.equals("")) {
                    strings.add(Integer.parseInt(String.valueOf(startIndex)), temp);
                }
            } else if (command.equals("divide")) {
                String element = strings.get(Integer.parseInt(String.valueOf(index)));
//                if (partitions.equals("0")) {
//                    partitions = "1";
//                }
                strings.remove(Integer.parseInt(String.valueOf(index)));
                int partSize = element.length() / Integer.parseInt(String.valueOf(partitions));
                splitByNumber(strings, element, Integer.parseInt(String.valueOf(index)), Integer.parseInt(String.valueOf(partitions)), partSize);

//                if (element.length() % Integer.parseInt(String.valueOf(partitions)) == 0) {
////                    String[] temp = splitByNumber(element, Integer.parseInt(String.valueOf(partitions)) / 2);
//                    String[] temp = splitByNumber(element, Integer.parseInt(String.valueOf(partitions)));
////                    if (temp == null) {
////                        temp = new String[]{element};
////                    } else {
////                        Collections.reverse(Arrays.asList(temp));
////                    }
//                    for (int i = 0; i < temp.length; i++) {
//                        strings.add(Integer.parseInt(String.valueOf(index)), temp[i]);
//                    }
////                    strings.remove(element);
//                } else {
//                    //String[] temp = splitByNumber(element, Integer.parseInt(String.valueOf(partitions)) / 2);
//                    String[] temp = splitByNumber(element, Integer.parseInt(String.valueOf(partitions)));
////                    if (temp == null) {
////                        temp = new String[]{element};
////                    } else {
////                        Collections.reverse(Arrays.asList(temp));
////                    }
//                    for (int i = 0; i < temp.length; i++) {
//                        strings.add(Integer.parseInt(String.valueOf(index)), temp[i]);
//                    }
//                    strings.remove(element);
               // }
            }

            commands = scanner.nextLine().split(" ");
            command = commands[0];
        }


        for (String string : strings) {
            System.out.printf("%s ", string);
        }
//    3.  Получаваме команди докато не получим команда "3:1":
//        a).  При получаване на команда marge, трябва да се конкатенират всички думи от стартиращия индекс до крайния индекс
//            2)  marge {startIndex} {endIndex}
//            Example: {abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}
//                1) ако някой от индексите е извън рейнджа на масива, трябва да се вземе само това което е вътре.
//                    •	The startIndex and the endIndex will be in the range [-1000, 1000].
//                    •	The endIndex will ALWAYS be GREATER than the startIndex
//        b) Всеки път когато получим divide команда, трябва да се раздели елемента от дадения индекс на под-елементи с брой равна на дадената ни втора променлива
//            2)  divide {index} {partitions}
//                Example: {abcdef, ghi, jkl} -> divide 0 3 -> {ab, cd, ef, ghi, jkl}
//                1) ако стринга не може да бъде точно разделен на този брой думи, правим всички думи еднавко дълги, като последната я оставяме най-дълга
//                    Example: {abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}
//                            •	The index in the divide command will ALWAYS be INSIDE the array.
//                            •	The partitions will be in the range [0, 100].
//    6. При получаване на команда 3:1, прекъсваме цикъла и принтираме резултата разделен с празен спейс.
    }

    private static void splitByNumber(List<String> s,String element, int index, int partitions, int partSize) {
        int beginIndexOfStrings = 0;
        for (int i = 1; i < partitions; i++) {
            s.add(index,element.substring(beginIndexOfStrings, beginIndexOfStrings + partSize));
            index++;
            beginIndexOfStrings += partSize;
        }
        s.add(index, element.substring(beginIndexOfStrings));
    }
}
