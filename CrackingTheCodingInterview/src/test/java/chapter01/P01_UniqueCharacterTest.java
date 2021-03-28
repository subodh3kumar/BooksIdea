package chapter01;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class P01_UniqueCharacterTest {

    private P01_UniqueCharacter obj;

    @BeforeEach
    public void init() {
        obj = new P01_UniqueCharacter();
    }

    @Test
    @Order(1)
    @Disabled
    public void testNullOrEmpty() {
        Exception exception = assertThrows(NullPointerException.class, () -> obj.verifyUniqueCharacterUsingIntArray(""));
        String message = exception.getMessage();
        assertThat(message).isEqualTo("empty string");
    }

    @Test
    @Order(2)
    @Disabled
    public void testUniqueCharacterUsingIntArray() {
        long start = System.currentTimeMillis();
        boolean result = obj.verifyUniqueCharacterUsingIntArray("wxyzz");
        long end = System.currentTimeMillis();

        assertThat(result).isEqualTo(false);
        System.out.println("total time taken (int array): " + (end - start) + " ms");

        result = obj.verifyUniqueCharacterUsingIntArray("meow");
        assertThat(result).isEqualTo(true);
    }

    @Test
    @Order(3)
    @Disabled
    public void testUniqueCharacterUsingMap() {
        long start = System.currentTimeMillis();

        boolean result = obj.verifyUniqueCharacterUsingMap("abcdefghijklmnopqrstuvwxyzz");
        long end = System.currentTimeMillis();
        assertThat(result).isEqualTo(false);

        System.out.println("total time taken (map): " + (end - start) + " ms");

        result = obj.verifyUniqueCharacterUsingMap("meow");
        assertThat(result).isEqualTo(true);
    }

    @Test
    @Order(4)
    @Disabled
    public void testUniqueCharacterUsingBooleanArray() {
        long start = System.currentTimeMillis();
        boolean result = obj.verifyUniqueCharacterUsingBooleanArray("wxyzz");
        long end = System.currentTimeMillis();

        assertThat(result).isEqualTo(false);
        System.out.println("total time taken (boolean array): " + (end - start) + " ms");

        result = obj.verifyUniqueCharacterUsingBooleanArray("meow");
        assertThat(result).isEqualTo(true);
    }

    @Test
    @Order(5)
    public void testUniqueCharacterUsingBitwiseOperator() {
        long start = System.currentTimeMillis();
        boolean result = obj.verifyUniqueCharacterUsingBitwiseOperator("cdee");
        long end = System.currentTimeMillis();

        assertThat(result).isEqualTo(false);
        System.out.println("total time taken (boolean array): " + (end - start) + " ms");

        result = obj.verifyUniqueCharacterUsingBitwiseOperator("meow");
        assertThat(result).isEqualTo(true);
    }
}