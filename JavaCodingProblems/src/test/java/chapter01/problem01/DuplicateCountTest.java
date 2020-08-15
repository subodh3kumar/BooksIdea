package chapter01.problem01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DuplicateCountTest {

    private static DuplicateCount obj;

    @BeforeAll
    public static void init() {
        obj = new DuplicateCount();
    }

    @AfterAll
    public static void destroy() {
        obj = null;
    }

    @Test
    @DisplayName("test null string")
    public void testNullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            obj.countDuplicateChars(null);
        });
        String expectedMsg = "string is null";
        String actualMsg = exception.getMessage();
        assertThat(actualMsg).isEqualTo(expectedMsg);
    }

    @Test
    @DisplayName("test empty string")
    public void testEmptyString() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            obj.countDuplicateChars("  ");
        });
        String expectedMsg = "string is null";
        String actualMsg = exception.getMessage();
        assertThat(actualMsg).isEqualTo(expectedMsg);
    }

    @Test
    @DisplayName("test non-empty string")
    public void testString() {
        obj.countDuplicateChars("subodh");
    }
}