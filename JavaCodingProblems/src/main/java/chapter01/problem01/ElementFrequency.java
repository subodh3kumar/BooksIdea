package chapter01.problem01;

import model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class ElementFrequency {

    public Map<Character, Integer> countDuplicateCharsJava7(String string) {
        if (string == null || string.trim().equals("")) {
            throw new NullPointerException("string is null");
        }

        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            Character ch = string.charAt(i);
            if (result.containsKey(ch)) {
                int value = result.get(ch);
                result.put(ch, ++value);
            } else {
                result.put(ch, 1);
            }
        }
        return result;
    }

    public Map<Character, Long> countDuplicateCharsJava8Stream(String string) {
        if (string == null || string.trim().equals("")) {
            throw new NullPointerException("string is null");
        }
        return string.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(c -> c, counting()));
    }

    public Map<Character, Long> countDuplicateCharsJava8Compute(String string) {
        if (string == null || string.trim().equals("")) {
            throw new NullPointerException("string is null");
        }
        Map<Character, Long> result = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public Map<String, List<Employee>> getEmployeesByDepartmentUsingJava7(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new NullPointerException("employee list is null or empty");
        }
        Map<String, List<Employee>> result = new HashMap<>();

        for (Employee employee : employees) {
            String deptName = employee.getDepartment();
            if (result.containsKey(deptName)) {
                List<Employee> list = result.get(deptName);
                list.add(employee);
            } else {
                List<Employee> list = new ArrayList<>();
                list.add(employee);
                result.put(deptName, list);
            }
        }
        return result;
    }

    public Map<String, List<Employee>> getEmployeesByDepartmentUsingJava8(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new NullPointerException("employee list is null or empty");
        }
        return employees.stream().collect(groupingBy(Employee::getDepartment));
    }

    public Map<String, List<String>> getEmployeeNameByDepartmentUsingJava8(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new NullPointerException("employee list is null or empty");
        }
        return employees.stream()
                .collect(groupingBy(Employee::getDepartment, mapping(Employee::getName, toList())));
    }

    public Map<String, Long> wordFrequency(List<String> words) {
        if (words == null || words.isEmpty()) {
            throw new NullPointerException("employee list is null or empty");
        }
        return words.stream().collect(groupingBy(Function.identity(), counting()));
    }
}
