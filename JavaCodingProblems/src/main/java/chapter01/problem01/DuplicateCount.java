package chapter01.problem01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCount {

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
        result.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
        return result;
    }

    public Map<Character, Long> countDuplicateCharsJava8Stream(String string) {
        if (string == null || string.trim().equals("")) {
            throw new NullPointerException("string is null");
        }
        Map<Character, Long> result = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        result.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
        return result;
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
        result.forEach((k, v) -> System.out.println("key: " + k + ", value: " + v));
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
        result.forEach(this::displayEmployee);
        return result;
    }

    private void displayEmployee(String deptName, List<Employee> employees) {
        System.out.println("deptName: " + deptName);
        System.out.println("employees: " + employees);
    }
}
