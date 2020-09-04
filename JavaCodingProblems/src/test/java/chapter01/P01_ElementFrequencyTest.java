package chapter01;

import model.Employee;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class P01_ElementFrequencyTest {

    private static P01_ElementFrequency obj;

    @BeforeAll
    public static void init() {
        obj = new P01_ElementFrequency();
    }

    @Test
    @Order(1)
    @Disabled
    @DisplayName("test null string")
    public void testNullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> obj.countDuplicateCharsJava7(null));
        String expectedMsg = "string is null";
        String actualMsg = exception.getMessage();
        assertThat(actualMsg).isEqualTo(expectedMsg);
    }

    @Test
    @Order(2)
    @Disabled
    @DisplayName("test empty string")
    public void testEmptyString() {
        Exception exception = assertThrows(NullPointerException.class, () -> obj.countDuplicateCharsJava7("  "));
        String expectedMsg = "string is null";
        String actualMsg = exception.getMessage();
        assertThat(actualMsg).isEqualTo(expectedMsg);
    }

    @Test
    @Order(3)
    @Disabled
    @DisplayName("count duplicate chars using Java 7")
    public void testCountDuplicateCharsJava7() {
        assertThat(obj.countDuplicateCharsJava7("hello")).isNotEmpty();
    }

    @Test
    @Order(4)
    @Disabled
    @DisplayName("count duplicate chars using Java 8 stream")
    public void testCountDuplicateCharsJava8Stream() {
        assertThat(obj.countDuplicateCharsJava8Stream("hello")).isNotEmpty();
    }

    @Test
    @Order(5)
    @Disabled
    @DisplayName("count duplicate chars using Java 8 compute")
    public void testCountDuplicateCharsJava8Compute() {
        assertThat(obj.countDuplicateCharsJava8Compute("hello")).isNotEmpty();
    }

    @Test
    @Order(6)
    @Disabled
    @DisplayName("employee group by department using Java 7")
    public void testEmployeeByDepartmentUsingJava7() {
        Map<String, List<Employee>> result = obj.getEmployeesByDepartmentUsingJava7(Employee.employees());
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @Order(7)
    @Disabled
    @DisplayName("employee group by department using Java 8")
    public void testEmployeeByDepartmentUsingJava8() {
        Map<String, List<Employee>> result = obj.getEmployeesByDepartmentUsingJava8(Employee.employees());
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @Order(8)
    @Disabled
    @DisplayName("employee name group by department using Java 8")
    public void testEmployeeNameByDepartmentUsingJava8() {
        Map<String, List<String>> result = obj.getEmployeeNameByDepartmentUsingJava8(Employee.employees());
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @Order(9)
    @DisplayName("word frequency")
    public void testWordFrequency() {
        List<String> words = List.of("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = obj.wordFrequency(words);
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(4);
    }
}