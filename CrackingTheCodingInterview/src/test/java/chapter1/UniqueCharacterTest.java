package chapter1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueCharacterTest {

    @Test
    public void testUniqueChar() {
        UniqueCharacter obj = new UniqueCharacter();
        Assertions.assertThat(false).isEqualTo(obj.isUniqueChar("subodh"));
    }
}