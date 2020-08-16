package chapter01.problem01;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCount {

    public Map<Character, Integer> countDuplicateCharsJava7(String string) {
        if (string == null || string.trim().equals("")) {
            throw new NullPointerException("string is null");
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character ch = string.charAt(i);
            if (map.containsKey(ch)) {
                int value = map.get(ch);
                map.put(ch, ++value);
            } else {
                map.put(ch, 1);
            }
        }
        map.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
        return map;
    }
}
