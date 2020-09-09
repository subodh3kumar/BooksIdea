package chapter01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_FirstNonRepeatableCharacterTest {

    private P02_FirstNonRepeatableCharacter obj;

    @BeforeEach
    public void init() {
        obj = new P02_FirstNonRepeatableCharacter();
    }

    @Test
    public void testNullOrEmptyString() {
        char ch = obj.firstNonRepeatableChar("");
        Assertions.assertThat(ch).isEqualTo(Character.MIN_VALUE);
    }

    @Test
    public void testFirstNonRepeatableChar() {
        char ch = obj.firstNonRepeatableChar("hello");
        Assertions.assertThat(ch).isEqualTo('h');
    }
}