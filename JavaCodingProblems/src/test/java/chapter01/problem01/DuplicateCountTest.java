package chapter01.problem01;

import org.junit.jupiter.api.*;

import java.util.List;

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
    @Disabled
    @DisplayName("test null string")
    public void testNullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            obj.countDuplicateCharsJava7(null);
        });
        String expectedMsg = "string is null";
        String actualMsg = exception.getMessage();
        assertThat(actualMsg).isEqualTo(expectedMsg);
    }

    @Test
    @Disabled
    @DisplayName("test empty string")
    public void testEmptyString() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            obj.countDuplicateCharsJava7("  ");
        });
        String expectedMsg = "string is null";
        String actualMsg = exception.getMessage();
        assertThat(actualMsg).isEqualTo(expectedMsg);
    }

    @Test
    @Disabled
    @DisplayName("count duplicate chars using Java 7")
    public void testCountDuplicateCharsJava7() {
        assertThat(obj.countDuplicateCharsJava7("hello")).isNotEmpty();
    }

    @Test
    @Disabled
    @DisplayName("count duplicate chars using Java 8 stream")
    public void testCountDuplicateCharsJava8Stream() {
        assertThat(obj.countDuplicateCharsJava8Stream("hello")).isNotEmpty();
    }

    @Test
    @Disabled
    @DisplayName("count duplicate chars using Java 8 compute")
    public void testCountDuplicateCharsJava8Compute() {
        assertThat(obj.countDuplicateCharsJava8Compute("hello")).isNotEmpty();
    }

    @Test
    @DisplayName("employee group by department using Java 7")
    public void testEmployeeByDepartment() {
        assertThat(obj.getEmployeesByDepartmentUsingJava7(getEmployees())).isNotEmpty();
    }

    public List<Employee> getEmployees() {
        return List.of(
                new Employee(7839, "KING", 5000, "ACCOUNTING"),
                new Employee(7698, "BLAKE", 2850, "SALES"),
                new Employee(7782, "CLARK", 2450, "ACCOUNTING"),
                new Employee(7566, "JONES", 2975, "RESEARCH"),
                new Employee(7788, "SCOTT", 3000, "RESEARCH"),
                new Employee(7902, "FORD", 3000, "RESEARCH"),
                new Employee(7369, "SMITH", 800, "RESEARCH"),
                new Employee(7499, "ALLEN", 1600, "SALES"),
                new Employee(7521, "WARD", 1250, "SALES"),
                new Employee(7654, "MARTIN", 1250, "SALES"),
                new Employee(7844, "TURNER", 1500, "SALES"),
                new Employee(7876, "ADAMS", 1100, "RESEARCH"),
                new Employee(7900, "JAMES", 950, "SALES"),
                new Employee(7934, "MILLER", 1300, "ACCOUNTING")
        );
    }
}