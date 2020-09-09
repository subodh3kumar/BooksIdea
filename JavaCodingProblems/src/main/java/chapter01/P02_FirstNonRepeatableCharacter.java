package chapter01;

public class P02_FirstNonRepeatableCharacter {

    public char firstNonRepeatableChar(String word) {
        if (word == null || word.isBlank()) {
            return Character.MIN_VALUE;
        }
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int count = 0;
            for (int j = 0; j < word.length(); j++) {
                if (ch == word.charAt(j) && i != j) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }
}
