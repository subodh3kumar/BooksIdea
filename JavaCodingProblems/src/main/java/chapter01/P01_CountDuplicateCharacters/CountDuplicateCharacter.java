package chapter01.P01_CountDuplicateCharacters;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateCharacter {

    private CountDuplicateCharacter() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Map<Character, Integer> countDuplicateUsingMap(String text) {
        long startTime = System.nanoTime();
        if (text == null || text.isBlank()) {
            return Collections.emptyMap();
        }
        var result = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            var ch = text.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        long endTime = System.nanoTime();
        System.out.println("Total time taken: " + (endTime - startTime) + " ns.");
        return result;
    }

    public static Map<Character, Long> countDuplicateUsingFunctional(String text) {
        long startTime = System.nanoTime();
        if (text == null || text.isBlank()) {
            return Collections.emptyMap();
        }
        Map<Character, Long> result = text.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        long endTime = System.nanoTime();
        System.out.println("Total time taken: " + (endTime - startTime) + " ns.");
        return result;
    }

    public static Map<String, Integer> countDuplicateUsingMapCP(String text) {
        long startTime = System.nanoTime();
        if (text == null || text.isBlank()) {
            return Collections.emptyMap();
        }
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            int cp = text.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if (Character.charCount(cp) == 2) {
                i++;
            }
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        long endTime = System.nanoTime();
        System.out.println("Total time taken: " + (endTime - startTime) + " ns.");
        return result;
    }

    public static Map<String, Long> countDuplicateUsingFunctionalCP(String text) {
        long startTime = System.nanoTime();
        if (text == null || text.isBlank()) {
            return Collections.emptyMap();
        }
        Map<String, Long> result = text.codePoints()
                .mapToObj(ch -> String.valueOf(Character.toChars(ch)))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        long endTime = System.nanoTime();
        System.out.println("Total time taken: " + (endTime - startTime) + " ns.");
        return result;
    }
}
