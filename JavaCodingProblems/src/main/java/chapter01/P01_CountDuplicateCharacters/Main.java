package chapter01.P01_CountDuplicateCharacters;

import java.util.Arrays;
import java.util.Map;

public class Main {

    private static final String TEXT = "Be strong, be fearless, be beautiful. " +
            "And believe that anything is possible when you have the right " +
            "people there to support you.";
    private static final String TEXT_CP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) {
        // Map style solution - TEXT
        Map<Character, Integer> duplicateCountMap = CountDuplicateCharacter.countDuplicateUsingMap(TEXT);
        //duplicateCountMap.forEach((k, v) -> System.out.println(k + "=" + v));
        System.out.println(Arrays.toString(duplicateCountMap.entrySet().toArray()));

        System.out.println("-----------------");

        // Functional style solution - TEXT
        Map<Character, Long> duplicateCountFunctional = CountDuplicateCharacter.countDuplicateUsingFunctional(TEXT);
        System.out.println(Arrays.toString(duplicateCountFunctional.entrySet().toArray()));

        System.out.println("-----------------");

        // Map style solution - TEXT_CP
        Map<String, Integer> duplicateCountMapCP = CountDuplicateCharacter.countDuplicateUsingMapCP(TEXT_CP);
        System.out.println(Arrays.toString(duplicateCountMapCP.entrySet().toArray()));

        System.out.println("-----------------");

        // Map style solution - TEXT_CP
        Map<String, Long> duplicateCountFunctionalCP = CountDuplicateCharacter.countDuplicateUsingFunctionalCP(TEXT_CP);
        System.out.println(Arrays.toString(duplicateCountFunctionalCP.entrySet().toArray()));
    }
}
