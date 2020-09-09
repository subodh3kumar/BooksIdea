package chapter01;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class P01_UniqueCharacter {

    public boolean verifyUniqueCharacterUsingIntArray(String word) {
        if (word == null || word.length() == 0) {
            throw new NullPointerException("empty string");
        }
        word = word.toLowerCase();
        int[] array = new int[26];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        for (int i = 0; i < word.length(); i++) {
            short index = (short) ('z' - word.charAt(i));
            int value = array[index];
            array[index] = ++value;
            if (array[index] > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyUniqueCharacterUsingMap(String word) {
        if (word == null || word.length() == 0) {
            throw new NullPointerException("empty string");
        }
        Map<Character, Long> result = word.toLowerCase().chars()
                .mapToObj(ch -> (char) ch).collect(groupingBy(ch -> ch, counting()));
        return !result.entrySet().stream().anyMatch(entry -> entry.getValue() > 1);
    }

    public boolean verifyUniqueCharacterUsingBooleanArray(String word) {
        if (word == null || word.length() == 0) {
            throw new NullPointerException("empty string");
        }
        word = word.toLowerCase();
        boolean[] array = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            int value = 'z' - word.charAt(i);
            if (array[value]) {
                return false;
            }
            array[value] = true;
        }
        return true;
    }

    public boolean verifyUniqueCharacterUsingBitwiseOperator(String word) {
        if (word == null || word.length() == 0) {
            throw new NullPointerException("empty string");
        }
        word = word.toLowerCase();
        int checker = 0;
        for (int i = 0; i < word.length(); i++) {
            int value = word.charAt(i) - 'a';
            if ((checker & (1 << value)) > 0) {
                return false;
            }
            checker |= (1 << value);
        }
        return true;
    }
}
