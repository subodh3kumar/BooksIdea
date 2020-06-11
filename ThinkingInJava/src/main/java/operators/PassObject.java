package operators;

public class PassObject {

    public static void foo(Letter letter) {
        letter.ch = 'z';
    }

    public static void main(String[] args) {
        Letter letter = new Letter();
        letter.ch = 'a';
        System.out.println("1: letter.ch: " + letter.ch);
        foo(letter);
        System.out.println("2: letter.ch: " + letter.ch);

    }
}

class Letter {
    char ch;
}