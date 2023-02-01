/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 1.2.2023 г.
 * Time: 5:42
 */
package P19ExerciseObjectsAndClasses;

import java.util.*;
import java.util.stream.Collectors;

public class P01AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> phrases  = new ArrayList<>();
        phrases .add("Excellent product.");
        phrases .add("Such a great product.");
        phrases .add("I always use that product.");
        phrases .add("Best product of its category.");
        phrases .add("Exceptional product.");
        phrases .add("I can’t live without this product.");
        List<String> events = new ArrayList<>();
        events.add("Now I feel good.");
        events.add("I have succeeded with this product.");
        events.add("Makes miracles. I am happy of the results!");
        events.add("I cannot believe but now I feel awesome.");
        events.add("Try it yourself, I am very satisfied.");
        events.add("I feel great!");
        List<String> authors = new ArrayList<>();
        authors.add("Diana");
        authors.add("Petya");
        authors.add("Stella");
        authors.add("Elena");
        authors.add("Katya");
        authors.add("Iva");
        authors.add("Annie");
        authors.add("Eva");
        List<String> cities = new ArrayList<>();
        cities.add("Burgas");
        cities.add("Sofia");
        cities.add("Plovdiv");
        cities.add("Varna");
        cities.add("Ruse");
        Random random = new Random();
        int numberOfSequences = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = 0; i < numberOfSequences; i++) {

                int newIndex = random.nextInt(cities.size());
                System.out.printf("%s %s %s – %s%n", phrases.get(newIndex), events.get(newIndex), authors.get(newIndex), cities.get(newIndex));
                phrases.remove(newIndex);
                events.remove(newIndex);
                authors.remove(newIndex);
                cities.remove(newIndex);
                i--;
                counter++;
            if (counter == numberOfSequences) {
                break;
            }
        }
    }
}
