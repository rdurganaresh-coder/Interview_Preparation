package com.mastery.corejava.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {

    public record Employee(String name, String dept, double salary) {}

    public Map<String, Double> averageSalaryByDept(List<Employee> employees) {
        return employees.stream().collect(
                Collectors.groupingBy(Employee::dept, Collectors.averagingDouble(Employee::salary)));
    }
}
