package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int id;
    private String name;
    private int salary;
    private String department;

    public static List<Employee> employees() {
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
