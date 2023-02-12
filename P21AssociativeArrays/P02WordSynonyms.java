/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 5.2.2023 г.
 * Time: 15:15
 */
package P21AssociativeArrays;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, List<String>> wordSynonyms = new LinkedHashMap<>();
        int runs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < runs; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            if (wordSynonyms.containsKey(word)){
                List<String> tempList = wordSynonyms.get(word);
                tempList.add(synonym);
                wordSynonyms.put(word, tempList);
            }else {
                List<String> tempList = new ArrayList<>();
                tempList.add(synonym);
                wordSynonyms.put(word,tempList);
            }
        }
        for (Map.Entry<String, List<String>> stringListEntry : wordSynonyms.entrySet()) {
            System.out.printf("%s - ",stringListEntry.getKey());
            List<String> temp = stringListEntry.getValue();
            System.out.println(String.join(", ", temp));
        }
    }
}
